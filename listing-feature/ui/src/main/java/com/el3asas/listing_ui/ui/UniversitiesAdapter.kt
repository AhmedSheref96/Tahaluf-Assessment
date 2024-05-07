package com.el3asas.listing_ui.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.el3asas.domain.models.UniversityItem
import com.el3asas.listing_ui.databinding.ItemUniversitiyBinding

class UniversitiesAdapter(private val listener: ItemClickListener) :
    RecyclerView.Adapter<UniversitiesAdapter.UniversitiesViewHolder>() {

    var dataList: List<UniversityItem> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class UniversitiesViewHolder(val binding: ItemUniversitiyBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UniversitiesViewHolder =
        UniversitiesViewHolder(
            binding = ItemUniversitiyBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: UniversitiesViewHolder, position: Int) {
        val item = dataList[position]
        holder.binding.apply {
            country.text = item.name
            name.text = item.name
            root.setOnClickListener {
                listener.onItemClicked(item)
            }
        }
    }

    interface ItemClickListener {
        fun onItemClicked(item: UniversityItem)
    }
}