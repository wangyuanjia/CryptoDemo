package com.rain.cryptodemo

import com.rain.cryptodemo.adapter.CryptoAdapter
import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.rain.cryptodemo.data.CryptoBean
import com.rain.cryptodemo.databinding.CryptoLayoutBinding
import com.rain.cryptodemo.viewmodel.CryptoViewModel
import com.rain.cryptodemo.viewmodel.UiState
import kotlinx.coroutines.launch

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
        viewModel.accessData()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initView() {

        binding.RV.layoutManager = LinearLayoutManager(this)
        val items = mutableListOf<CryptoBean>()
        val adapter = CryptoAdapter(items = items)
        binding.RV.adapter = adapter

        lifecycleScope.launch {
            viewModel.uiState.collect { state ->
                when (state) {
                    is UiState.Loading -> {

                    }

                    is UiState.Success -> {
                        val sum = state.data.sumOf {
                            it.money?.toDoubleOrNull() ?: 0.0
                        }
                        binding.tvTotal.text = "$ ${sum.toString()} USD"
                        Log.d("CryptoActivity","state.data"+state.data)
                        adapter.items = state.data
                        adapter.notifyDataSetChanged()

                    }

                    is UiState.Error -> {

                    }

                }


            }
        }

    }


}