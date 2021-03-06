package com.develop.rubenpla.abatest.view.home.presenter

import com.develop.rubenpla.abatest.model.mapper.CsvMapper
import com.develop.rubenpla.abatest.util.cache.CacheManager
import com.develop.rubenpla.abatest.view.base.presenter.BasePresenter
import com.develop.rubenpla.abatest.view.home.view.HomeFragmentView
import com.develop.rubenpla.abatest.api.CsvApi
import com.develop.rubenpla.abatest.api.CsvRepository
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.processors.PublishProcessor
import javax.inject.Inject

class HomeFragmentPresenter @Inject constructor() : BasePresenter<HomeFragmentView>() {

    private val disposables : CompositeDisposable = CompositeDisposable()
    private lateinit var paginator : PublishProcessor<Boolean>

    private var isConnected = true //TODO maybe not useful here CHECK IT, SMELL

    fun loadDataFromCsv() {
        paginator = PublishProcessor.create()

        val disposable = paginator.onBackpressureDrop()
                .filter{ isConnected }
                .concatMap { getCsvFile(isConnected) }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    var result = it
                    result = result?.replace("\"", "")

                    CacheManager.writeToCache(result)
                    view!!.setCsvDataToRecyclerView(CsvMapper.mapToList(result))
                }, {
                    val cachedCsvFile  = CacheManager.readFromCacheFile()

                    if (!cachedCsvFile.isNullOrEmpty()) {
                        view!!.showError("[${it.message.toString()}], " +
                                "trying to load cached content.")
                        view!!.setCsvDataToRecyclerView(CsvMapper.mapToList(cachedCsvFile))
                    } else {
                        view!!.showError("[${it.message.toString()}], " +
                                "no cached content, try again later")
                    }
                })

        disposables.add(disposable)
        load()
    }

    private fun getCsvFile(isConnected : Boolean): Flowable<String?>? {
        val csvRepository  = CsvRepository(CsvApi.getInstance())

        return Flowable.just(isConnected)
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap { _ -> csvRepository.getCsv() }
    }

    private fun load() {
        paginator.onNext(isConnected)
    }

    override fun terminate() {
        disposables.clear()
    }
}