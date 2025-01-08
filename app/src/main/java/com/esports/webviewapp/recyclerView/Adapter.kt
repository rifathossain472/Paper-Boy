package com.esports.webviewapp.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.esports.webviewapp.data.Item
import com.esports.webviewapp.databinding.ItemLayoutBinding

class Adapter(private val itemList: List<Item>, private val handleClickListener: HandleClickListener): RecyclerView.Adapter<Adapter.ViewHolder>() {
    class ViewHolder(val binding: ItemLayoutBinding): RecyclerView.ViewHolder(binding.root)

    interface HandleClickListener{
        fun clickItem(url: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.binding.apply {
            itemIv.setImageResource(item.itemImage)

            root.setOnClickListener {
                handleClickListener.clickItem(item.url)
            }
        }

    }
}