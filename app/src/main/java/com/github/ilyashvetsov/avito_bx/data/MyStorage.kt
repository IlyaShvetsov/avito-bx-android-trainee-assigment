package com.github.ilyashvetsov.avito_bx.data

import androidx.lifecycle.MutableLiveData
import java.util.*
import kotlin.concurrent.thread



class MyStorage {
    val items = MutableLiveData<List<Int>>().apply {
        value = listOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15)
    }
    var nextItem = 16
    private val deletedItemPool = TreeSet<Int>()

    init {
        thread {
            while (true) {
                Thread.sleep(5000)
                addItem()
            }
        }
    }

    private fun addItem() {
        val size = items.value?.size ?: 0
        val position = (0..size).random()

        val newList = items.value?.toMutableList()
        newList?.add(position, getNewItem())
        items.postValue(newList)
    }

    private fun getNewItem(): Int {
        return if (deletedItemPool.isEmpty()) {
            nextItem++
        } else {
            val selectedItem = deletedItemPool.first()
            deletedItemPool.remove(selectedItem)
            selectedItem
        }
    }

    fun deleteItem(index: Int) {
        val newList = items.value?.minus(index)
        items.postValue(newList)
        deletedItemPool.add(index)
    }

}
