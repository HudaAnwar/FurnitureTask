package com.huda.furnituretask.presentation.adapters

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.huda.furnituretask.databinding.ItemGalleryBinding
import com.huda.furnituretask.databinding.ItemGalleryVerticalBinding
import com.huda.furnituretask.domain.model.Gallery
import com.huda.furnituretask.interfaces.OnAdapterItemClickHandler

class GalleriesAdapter(
    var context: Context,
    var galleriesList: List<Gallery>,
    var viewType: Int,
    var onClickHandler: OnAdapterItemClickHandler
) :
    RecyclerView.Adapter<GalleriesAdapter.ParentViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder {
        return when (this.viewType) {
            0 -> {
                ParentViewHolder(
                    ItemGalleryBinding.inflate(LayoutInflater.from(context), parent, false)
                )
            }
            else -> {
                ParentViewHolder(
                    ItemGalleryVerticalBinding.inflate(LayoutInflater.from(context), parent, false)
                )
            }

        }
    }

    override fun onBindViewHolder(holder: ParentViewHolder, position: Int) {
        when (viewType) {
            0 -> {
                holder.setDataHorizontal(galleriesList[position])
            }
            1 -> {
                holder.setDataVertical(galleriesList[position])
            }
        }
    }

    fun updateList(galleriesList: List<Gallery>) {
        notifyItemRangeRemoved(0, this.galleriesList.size)
        this.galleriesList = galleriesList
        notifyItemRangeInserted(0, galleriesList.size)
    }

    override fun getItemCount(): Int {
        return galleriesList.size
    }

    inner class ParentViewHolder(private val binding: ViewBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            when (p0) {
                itemView -> {
                    onClickHandler
                        .onItemClicked(galleriesList[adapterPosition].id, Gallery::javaClass.name)
                }
            }
        }

        fun setDataHorizontal(gallery: Gallery) {

            with(binding as ItemGalleryBinding) {
                Glide.with(context).load(gallery.logo).into(galleryImg)
                galleryName.text = gallery.name
            }
        }

        fun setDataVertical(gallery: Gallery) {
            with(binding as ItemGalleryVerticalBinding) {
                Glide.with(context).load(gallery.logo).into(galleryImg)
                galleryName.text = gallery.name
                address.text = gallery.address
                rateCount.text = gallery.rateCount
                rating.rating = gallery.rate?.toFloat() ?: 0f
                isFav.isFavorite = gallery.isFav ?: false
                branchTypeName.text = gallery.branchTypeName
            }
        }

    }

}