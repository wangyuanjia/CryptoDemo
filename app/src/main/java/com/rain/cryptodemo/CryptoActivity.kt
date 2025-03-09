package com.rain.cryptodemo

import com.rain.cryptodemo.adapter.CryptoAdapter
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rain.cryptodemo.data.CryptoBean
import com.rain.cryptodemo.databinding.CryptoLayoutBinding
import com.rain.cryptodemo.viewmodel.CryptoViewModel

class CryptoActivity : AppCompatActivity() {


    private lateinit var binding: CryptoLayoutBinding
    private lateinit var viewModel: CryptoViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CryptoLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root) // 设置布局
        // 使用ViewModelProvider获取ViewModel
        viewModel = ViewModelProvider(this)[CryptoViewModel::class.java]

        initView()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initView() {
//        binding.tvTotal.text = ""
        binding.RV.layoutManager = LinearLayoutManager(this)
        val items = mutableListOf<CryptoBean>()
        items.add((CryptoBean()))
        val adapter = CryptoAdapter(items = items)
        binding.RV.adapter = adapter
        adapter.itemCount
        println(" adapter.itemCount" + adapter.itemCount)
    }


}