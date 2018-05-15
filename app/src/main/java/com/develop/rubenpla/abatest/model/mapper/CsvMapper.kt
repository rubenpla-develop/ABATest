package com.develop.rubenpla.abatest.model.mapper

import com.develop.rubenpla.abatest.model.CsvItemModel

object CsvMapper {
    private const val CSV_TITLE_IDX = 0
    private const val CSV_DESCRIPTION_IDX = 1
    private const val CSV_IMAGE_URL_IDX = 2

    fun mapToList(csvString : String?) : ArrayList<CsvItemModel> {
        val itemList : ArrayList<CsvItemModel> = ArrayList()

        val csvList = csvString!!.lines()
        val listSize = csvList.size - 1

        for (line in 1 until listSize) {
            val fields = csvList[line].split(",")

            if (fields.size == 3) {
                itemList.add(mapToModel(fields))
            }
        }

        return itemList
    }

    private fun mapToModel(fields : List<String>) : CsvItemModel {
        return CsvItemModel(
                fields[CSV_TITLE_IDX],
                fields[CSV_DESCRIPTION_IDX],
                fields[CSV_IMAGE_URL_IDX])
    }
}