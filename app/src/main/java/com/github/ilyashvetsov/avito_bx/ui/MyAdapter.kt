package com.github.ilyashvetsov.avito_bx.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.ilyashvetsov.avito_bx.databinding.MyItemBinding



class MyAdapter(private val onClick : (Int) -> Unit) : RecyclerView.Adapter<MyViewHolder>() {
    private var dataList: List<Int> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val answerItemBinding = MyItemBinding.inflate(inflater, parent, false)
        return MyViewHolder(answerItemBinding, onClick)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount() = dataList.size

    fun setItems(answers: List<Int>) {
        val diffUtilsCallback = MyDiffUtil(dataList, answers)
        dataList = answers
        val diffResult = DiffUtil.calculateDiff(diffUtilsCallback)
        diffResult.dispatchUpdatesTo(this)
    }

}
