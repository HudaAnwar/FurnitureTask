package com.huda.furnituretask.presentation.ui.galleries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.huda.furnituretask.R
import com.huda.furnituretask.databinding.GalleriesFragmentBinding
import com.huda.furnituretask.domain.model.Gallery
import com.huda.furnituretask.interfaces.NavigationBarVisibilityListener
import com.huda.furnituretask.interfaces.OnAdapterItemClickHandler
import com.huda.furnituretask.presentation.adapters.GalleriesAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class GalleriesFragment : Fragment(), OnAdapterItemClickHandler {
    private var _binding: GalleriesFragmentBinding? = null
    private val binding get() = _binding!!
    private val bundle = Bundle()

    val viewModel: GalleriesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = GalleriesFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.topAppBar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        val layoutManager = LinearLayoutManager(requireContext())
        val dividerItemDecoration = DividerItemDecoration(
            binding.recyclerView.context,
            layoutManager.orientation
        )
        binding.recyclerView.addItemDecoration(dividerItemDecoration)
        binding.recyclerView.layoutManager = layoutManager
        val adapter = GalleriesAdapter(requireContext(), listOf(), 1, this)
        binding.recyclerView.adapter = adapter
        viewModel.getGalleries(25.2121212, 24.1252152)
        viewModel.galleriesLiveData.observe(viewLifecycleOwner) { galleries ->
            adapter.updateList(galleries)
            adapter.notifyItemRangeInserted(0, galleries.size)
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

    override fun onItemClicked(itemId: Int?, type: String) {
        bundle.putInt("gallery_id", itemId ?: -1)
        findNavController().navigate(R.id.view_gallery_details, bundle)
    }
}