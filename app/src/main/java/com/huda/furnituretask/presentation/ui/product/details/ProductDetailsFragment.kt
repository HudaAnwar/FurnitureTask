package com.huda.furnituretask.presentation.ui.product.details

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.android.material.tabs.TabLayoutMediator
import com.huda.furnituretask.R
import com.huda.furnituretask.databinding.ProductDetailsFragmentBinding
import com.huda.furnituretask.domain.model.FurnitureImage
import com.huda.furnituretask.domain.model.Offer
import com.huda.furnituretask.interfaces.NavigationBarVisibilityListener
import com.huda.furnituretask.presentation.adapters.ImagesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailsFragment : Fragment() {

    private var _binding: ProductDetailsFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ProductDetailsViewModel by viewModels()
    private val productId = 45
    val images = listOf(
        FurnitureImage(
            156,
            156,
            "https://backend.forhomi.com/storage/product/C6eT4nmqO92PGDMib6j54pjy73hUL53HGMzpsdJv.png"
        ),
        FurnitureImage(
            156,
            156,
            "https://backend.forhomi.com/storage/product/C6eT4nmqO92PGDMib6j54pjy73hUL53HGMzpsdJv.png"
        ),
        FurnitureImage(
            156,
            156,
            "https://backend.forhomi.com/storage/product/C6eT4nmqO92PGDMib6j54pjy73hUL53HGMzpsdJv.png"
        ),
        FurnitureImage(
            156,
            156,
            "https://backend.forhomi.com/storage/product/C6eT4nmqO92PGDMib6j54pjy73hUL53HGMzpsdJv.png"
        ),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ProductDetailsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imagesAdapter = ImagesAdapter(requireContext(), images)
        binding.productImg.viewPager2.adapter = imagesAdapter
        binding.productImg.dotsIndicator.attachTo(binding.productImg.viewPager2)

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