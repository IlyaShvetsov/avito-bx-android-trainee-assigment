package com.github.ilyashvetsov.avito_bx.ui

import androidx.lifecycle.*
import com.github.ilyashvetsov.avito_bx.data.MyStorage



class MyViewModel : ViewModel() {
    private val mG = MyStorage()
    val items: LiveData<List<Int>> = mG.items

    fun deleteItem(index: Int) {
        mG.deleteItem(index)
    }

}
