package com.huda.furnituretask.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.huda.furnituretask.databinding.ItemProductBinding
import com.huda.furnituretask.domain.model.Product

class ItemProductAdapter(var context: Context, var productsList: List<Product>) :
    RecyclerView.Adapter<ItemProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemProductBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )
    }

    fun updateList(productsList: List<Product>) {
        notifyItemRangeRemoved(0, this.productsList.size)
        this.productsList = productsList
        notifyItemRangeInserted(0, productsList.size)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(productsList[position])
    }

    override fun getItemCount(): Int {
        return productsList.size

    }

    inner class ViewHolder(private val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setData(product: Product) {
            with(binding) {
                Glide.with(context)
                    .asBitmap()
                    .load(product.icon)
                    .into(productImg)
                productQty.text = product.quantity.toString()
                productName.text = product.product.toString()
            }
        }

    }
}