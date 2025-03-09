package com.rain.cryptodemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rain.cryptodemo.data.CryptoBean
import com.rain.cryptodemo.databinding.CryptoItemBinding

class CryptoAdapter(
    private val items: List<CryptoBean>,
    private val onItemClick: ((CryptoBean) -> Unit)? = null
) : RecyclerView.Adapter<CryptoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // 使用 ViewBinding 绑定布局
        val binding = CryptoItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(
        private val binding: CryptoItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CryptoBean) {
            // 直接通过 binding 访问视图
//            binding.tvCryptoName.text = item.cryptoName
//            binding.tvSymbol.text = ""
//            binding.tvAmount.text = ""
        }
    }
}