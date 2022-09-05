package com.huda.furnituretask.presentation.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.huda.furnituretask.domain.model.GalleryDetails
import com.huda.furnituretask.presentation.ui.galleries.gallery_details.AboutGalleryFragment
import com.huda.furnituretask.presentation.ui.galleries.gallery_details.GalleryPageFragment
import com.huda.furnituretask.presentation.ui.galleries.gallery_details.GalleryReviewsFragment


class TabsAdapter(fragment: Fragment, var galleryDetails: GalleryDetails) :
    FragmentStateAdapter(fragment) {
    companion object {
        public val ARG_OBJECT = "object"
        public val GALLERY_DETAILS = "Args"
    }

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        val galleryPageFragment = GalleryPageFragment()
        val galleryReviewsFragment = GalleryReviewsFragment()
        val aboutGalleryFragment = AboutGalleryFragment()
        return when (position) {
            0 -> {
                galleryPageFragment.arguments = Bundle().apply {
                    putParcelable(GALLERY_DETAILS, galleryDetails)
                }
                galleryPageFragment
            }
            1 -> {
                galleryReviewsFragment.arguments = Bundle().apply {
                    putParcelable(GALLERY_DETAILS, galleryDetails)
                }
                galleryReviewsFragment
            }
            2 -> {
                aboutGalleryFragment.arguments = Bundle().apply {
                    putParcelable(GALLERY_DETAILS, galleryDetails)
                }
                aboutGalleryFragment
            }
            else -> {
                galleryPageFragment.arguments = Bundle().apply {
                    putParcelable(GALLERY_DETAILS, galleryDetails)
                }
                galleryPageFragment
            }
        }

    }
}