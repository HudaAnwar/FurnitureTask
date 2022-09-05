package com.huda.furnituretask.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.huda.furnituretask.databinding.ItemImageBinding
import com.huda.furnituretask.domain.model.FurnitureImage

class ImagesAdapter(var context: Context, var images: List<FurnitureImage>) :
    RecyclerView.Adapter<ImagesAdapter.ViewHolder>() {


    inner class ViewHolder(private val binding: ItemImageBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun setData(image: FurnitureImage) {
            with(binding) {
                Glide.with(context).load(image.path).into(furnitureImg)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemImageBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(images[position])
    }

    override fun getItemCount(): Int {
        return images.size
    }
}