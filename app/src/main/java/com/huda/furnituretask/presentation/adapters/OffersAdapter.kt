package com.huda.furnituretask.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.huda.furnituretask.databinding.ItemOfferBinding
import com.huda.furnituretask.domain.model.Offer
import com.huda.furnituretask.interfaces.OnAdapterItemClickHandler

class OffersAdapter(
    var context: Context,
    var offersList: List<Offer>,
    var onClickHandler: OnAdapterItemClickHandler
) :
    RecyclerView.Adapter<OffersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemOfferBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    fun updateList(offersList: List<Offer>) {
        notifyItemRangeRemoved(0, this.offersList.size)
        this.offersList = offersList
        notifyItemRangeInserted(0, offersList.size)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(offersList[position])
    }

    override fun getItemCount(): Int {
        return offersList.size
    }

    inner class ViewHolder(private val binding: ItemOfferBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }

        fun setData(offer: Offer) {

            with(binding) {
                offerPrice.text = offer.price.toString()
                Glide.with(itemView.context).load(offer.furnitureLogo).into(galleryImg)
                setProductRecyclerView(offer)
                offerTxt.text = offer.name
                galleryName.text = offer.furnitureName
                setImagesViewPager(offer)
            }
        }

        private fun setImagesViewPager(offer: Offer) {
            val imagesAdapter = ImagesAdapter(itemView.context, offer.images)
            binding.viewPager.adapter = imagesAdapter
        }

        private fun setProductRecyclerView(offer: Offer) {
            val adapter = ItemProductAdapter(itemView.context, offer.products)
            val layoutManager =
                LinearLayoutManager(itemView.context)
            layoutManager.initialPrefetchItemCount = offer.products.size
            binding.recyclerView.layoutManager = layoutManager
            binding.recyclerView.adapter = adapter
            binding.recyclerView.addOnItemTouchListener(object :
                RecyclerView.OnItemTouchListener {
                override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
                    when (e.action) {
                        MotionEvent.ACTION_DOWN -> rv.parent.requestDisallowInterceptTouchEvent(true)
                    }
                    return false
                }

                override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
                    TODO("Not yet implemented")
                }

                override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
                    TODO("Not yet implemented")
                }

            })
        }

        override fun onClick(p0: View?) {
            when (p0) {
                itemView -> onClickHandler.onItemClicked(
                    offersList[adapterPosition].id, Offer::class.simpleName ?: "None"
                )
            }
        }

    }

}