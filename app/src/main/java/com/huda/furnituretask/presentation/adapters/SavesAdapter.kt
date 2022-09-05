package com.huda.furnituretask.presentation.adapters

import android.content.Context
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
import com.bumptech.glide.Glide
import com.huda.furnituretask.databinding.ItemSaveBinding
import com.huda.furnituretask.domain.model.Safe
import java.text.SimpleDateFormat
import java.util.*


class SavesAdapter(var context: Context, var savesList: List<Safe>) :
    RecyclerView.Adapter<SavesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemSaveBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    fun updateList(savesList: List<Safe>) {
        notifyItemRangeRemoved(0, this.savesList.size)
        this.savesList = savesList
        notifyItemRangeInserted(0, savesList.size)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(savesList[position])
    }

    override fun getItemCount(): Int {
        return savesList.size
    }

    inner class ViewHolder(private val binding: ItemSaveBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private var countDownTimer: CountDownTimer? = null

        fun setData(save: Safe) {

            with(binding) {
                Glide.with(context).load(save.furnitureLogo).into(galleryImg)
                salesPrice.text = save.price.toString()
                setProductRecyclerView(save)
                salesTxt.text = save.name
                salesGallery.text = save.furnitureName
                setImagesViewPager(save)
                setSaveTimer(save)

            }
        }

        private fun setSaveTimer(save: Safe) {
            val currentDate = Date()
            val endDateStr = "${save.end} ${save.to}"
            val endDate: Date = SimpleDateFormat(
                "yyyy-MM-dd hh:mm:ss",
                Locale.ENGLISH
            ).parse(endDateStr) as Date
            println(endDate)

            countDownTimer?.cancel()
            val diffTime = endDate.time - currentDate.time
            countDownTimer = object : CountDownTimer(diffTime, 1000) {
                override fun onTick(p0: Long) {
                    val seconds: Long = p0 / 1000
                    val minutes = seconds / 60
                    val hours = minutes / 60
                    val days = hours / 24
                    binding.days.text = String.format("%03d", days)
                    binding.hours.text = String.format("%02d", hours % 24)
                    binding.minutes.text = String.format("%02d", minutes % 60)
                    binding.seconds.text = String.format("%02d", seconds % 60)
                }

                override fun onFinish() {
                    TODO("Not yet implemented")
                }

            }.start()
        }

        private fun setImagesViewPager(save: Safe) {
            val imagesAdapter = ImagesAdapter(itemView.context, save.images)
            binding.viewPager.adapter = imagesAdapter
        }

        private fun setProductRecyclerView(save: Safe) {
            val adapter = ItemProductAdapter(itemView.context, save.products)
            val layoutManager =
                LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
            layoutManager.initialPrefetchItemCount = save.products.size
            binding.savesItemsRecyclerView.layoutManager = layoutManager
            binding.savesItemsRecyclerView.adapter = adapter
            binding.savesItemsRecyclerView.addOnItemTouchListener(object : OnItemTouchListener {
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

    }
}

