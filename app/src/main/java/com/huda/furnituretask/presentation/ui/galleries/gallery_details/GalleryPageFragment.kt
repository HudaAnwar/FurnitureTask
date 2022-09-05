package com.huda.furnituretask.presentation.ui.galleries.gallery_details

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.android.material.tabs.TabLayoutMediator
import com.huda.furnituretask.R
import com.huda.furnituretask.databinding.GalleryDetailsFragmentBinding
import com.huda.furnituretask.databinding.GalleryPageFragmentBinding
import com.huda.furnituretask.interfaces.NavigationBarVisibilityListener
import com.huda.furnituretask.presentation.adapters.TabsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GalleryPageFragment : Fragment() {
    private var _binding: GalleryPageFragmentBinding? = null
    private val binding get() = _binding!!


    val viewModel: GalleryDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = GalleryPageFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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