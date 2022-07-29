package com.huda.furnituretask.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.huda.furnituretask.R
import com.huda.furnituretask.databinding.ItemFurnitureBinding
import com.huda.furnituretask.util.FurnitureCategory

class CategoriesAdapter(var context: Context, var categoriesList: List<FurnitureCategory>) :
    RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemFurnitureBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(categoriesList[position])
    }

    override fun getItemCount(): Int {
        return categoriesList.size
    }

    inner class ViewHolder(private val binding: ItemFurnitureBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setData(category: FurnitureCategory) {

            with(binding) {
                typeImg.setImageResource(category.categoryImage)
                typeName.text = category.categoryName
            }
        }

    }

}