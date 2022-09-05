package com.huda.furnituretask.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.huda.furnituretask.databinding.ItemDiscountBinding
import com.huda.furnituretask.databinding.ItemSaveBinding
import com.huda.furnituretask.domain.model.Discount
import com.huda.furnituretask.domain.model.FurnitureCategory
import com.huda.furnituretask.domain.model.Offer

class DiscountAdapter(var context: Context, var discountsList: List<Discount>) :
    RecyclerView.Adapter<DiscountAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemDiscountBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    fun updateList(discountsList: List<Discount>) {
        notifyItemRangeRemoved(0, this.discountsList.size)
        this.discountsList = discountsList
        notifyItemRangeInserted(0, discountsList.size)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(discountsList[position])
    }

    override fun getItemCount(): Int {
        return discountsList.size
    }

    inner class ViewHolder(private val binding: ItemDiscountBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setData(discount: Discount) {

            with(binding) {
                "${discount.priceBefore} جنيه".also { discountPriceBefore.text = it }
                "${discount.priceAfter} جنيه".also { discountPriceAfter.text = it }
                setImagesViewPager(discount)
                discountItemDescription.text = discount.productDescription
                Glide.with(itemView.context).load(discount.furnitureLogo).into(galleryImg)
                "% ${discount.percent}".also { discountPercentage.text = it }
                discountTxt.text = discount.productName
                galleryName.text = discount.productName
            }
        }

        private fun setImagesViewPager(discount: Discount) {
            val imagesAdapter = ImagesAdapter(itemView.context, discount.images)
            binding.viewPager.adapter = imagesAdapter
        }


    }

}