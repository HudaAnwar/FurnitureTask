package com.huda.furnituretask.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.huda.furnituretask.databinding.ItemFurnitureBinding
import com.huda.furnituretask.domain.model.FurnitureCategory

class CategoriesAdapter(var context: Context, var categoriesList: List<FurnitureCategory>?) :
    RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemFurnitureBinding.inflate(LayoutInflater.from(context), parent, false))
    }
    fun updateList(categoriesList: List<FurnitureCategory>?){
        notifyItemRangeRemoved(0,this.categoriesList?.size?:0)
        this.categoriesList = categoriesList
        notifyItemRangeInserted(0, categoriesList?.size?:0)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(categoriesList?.get(position))
    }

    override fun getItemCount(): Int {
        return categoriesList?.size?:0
    }

    inner class ViewHolder(private val binding: ItemFurnitureBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setData(category: FurnitureCategory?) {

            with(binding) {
                Glide.with(context).load(category?.image).into(typeImg)
                typeName.text = category?.name
            }
        }

    }

}