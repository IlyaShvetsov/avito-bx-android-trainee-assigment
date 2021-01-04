package com.github.ilyashvetsov.avito_bx.ui

import androidx.recyclerview.widget.RecyclerView
import com.github.ilyashvetsov.avito_bx.databinding.MyItemBinding



class MyViewHolder(private val binding: MyItemBinding, private val onClick : (Int) -> Unit): RecyclerView.ViewHolder(binding.root) {

    fun bind(id: Int) {
        binding.index.text = id.toString()
        binding.deleteBtn.setOnClickListener { onClick(id) }
    }

}
