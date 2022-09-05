package com.huda.furnituretask.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.huda.furnituretask.R
import com.huda.furnituretask.databinding.ItemBranchTypeBinding
import com.huda.furnituretask.domain.model.BranchType

class BranchTypesAdapter(var context: Context, var branchTypesList: List<BranchType>) :
    RecyclerView.Adapter<BranchTypesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemBranchTypeBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )
    }

    fun updateList(branchTypesList: List<BranchType>) {
        notifyItemRangeRemoved(0, this.branchTypesList.size)
        this.branchTypesList = branchTypesList
        notifyItemRangeInserted(0, branchTypesList.size)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(branchTypesList[position])
    }

    override fun getItemCount(): Int {
        return branchTypesList.size
    }

    inner class ViewHolder(private val binding: ItemBranchTypeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setData(branchType: BranchType) {

            with(binding) {
                if (adapterPosition % 2 == 0) {
                    binding.root.setBackgroundResource(R.drawable.round_rect_red)
                } else {
                    binding.root.setBackgroundResource(R.drawable.round_rect_gold)
                }
                Glide.with(context).load(branchType.image).into(branchTypeImg)
                branchTypeName.text = branchType.name
            }
        }

    }

}