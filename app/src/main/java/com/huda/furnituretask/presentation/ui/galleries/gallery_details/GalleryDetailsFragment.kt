package com.huda.furnituretask.presentation.ui.galleries.gallery_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayoutMediator
import com.huda.furnituretask.databinding.GalleryDetailsFragmentBinding
import com.huda.furnituretask.domain.model.GalleryDetails
import com.huda.furnituretask.interfaces.NavigationBarVisibilityListener
import com.huda.furnituretask.presentation.adapters.TabsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GalleryDetailsFragment : Fragment() {
    private var _binding: GalleryDetailsFragmentBinding? = null
    private val binding get() = _binding!!
    private var galleryId: Int = -1

    val viewModel: GalleryDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        galleryId = arguments?.getInt("gallery_id") ?: -1
        _binding = GalleryDetailsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getGalleryDetails(galleryId)
        viewModel.galleryDetailsLiveData.observe(viewLifecycleOwner) { gallery ->
            binding.galleryName.text = gallery.furniture?.name
            binding.galleryDescription.text = gallery.furniture?.description
            binding.address.text = gallery.furniture?.address
            Glide.with(this).load(gallery.furniture?.logo).into(binding.galleryImg)
            binding.rating.rating = gallery.furniture?.rate?.toFloat() ?: 0f
            binding.rateCount.text = "${gallery.furniture?.rateCount}"
            val adapter = TabsAdapter(this, gallery)
            binding.viewPager.adapter = adapter
            TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
                run {
                    when (position) {
                        0 -> tab.text = "صفحة المعرض"
                        1 -> tab.text = "التقييم"
                        else -> tab.text = "معلومات عن المعرض"
                    }
                }
            }.attach()

        }

    }

    override fun onStart() {
        super.onStart()
        val navbarActivity = requireActivity() as NavigationBarVisibilityListener
        navbarActivity.navbarVisibility(View.GONE)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}