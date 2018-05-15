package com.develop.rubenpla.abatest.view.home.presenter

import com.develop.rubenpla.abatest.model.mapper.CsvMapper
import com.develop.rubenpla.abatest.view.base.presenter.BasePresenter
import com.develop.rubenpla.abatest.view.home.view.HomeFragmentView
import com.example.rubenpla.csvreadertest.CsvApi
import com.example.rubenpla.csvreadertest.CsvRepository
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

                    view!!.setCsvDataToRecyclerView(CsvMapper.mapToList(result))
                }, {
                    view!!.showError(it.toString())
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