package com.github.ilyashvetsov.avito_bx.ui

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.github.ilyashvetsov.avito_bx.databinding.ActivityMainBinding



class MyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MyViewModel
    private lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = MyAdapter { index -> deleteItem(index) }
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = GridLayoutManager(this, getSpanCount())

        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        viewModel.items.observe(this, { adapter.setItems(it) })
    }

    private fun deleteItem(index: Int) {
        viewModel.deleteItem(index)
    }

    private fun getSpanCount(): Int {
        var spanCount = 2
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            spanCount = 4
        }
        return spanCount
    }

}
