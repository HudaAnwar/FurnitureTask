package com.huda.furnituretask.presentation.ui.categories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.huda.furnituretask.R
import com.huda.furnituretask.databinding.CategoriesFragmentBinding
import com.huda.furnituretask.interfaces.NavigationBarVisibilityListener
import com.huda.furnituretask.presentation.adapters.CategoriesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoriesFragment : Fragment() {

    private val viewModel by viewModels<CategoriesViewModel>()
    private var _binding: CategoriesFragmentBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CategoriesFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val gridLayoutManager = GridLayoutManager(requireContext(), 4)
        binding.topAppBar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        viewModel.getCategories()
        viewModel.categoriesLiveData.observe(viewLifecycleOwner) { categories ->
            val adapter = CategoriesAdapter(requireContext(), categories)
            binding.recyclerView.layoutManager = gridLayoutManager
            binding.recyclerView.adapter = adapter
        }
    }

    override fun onStart() {
        super.onStart()
        val navbarActivity = requireActivity() as NavigationBarVisibilityListener
        navbarActivity.navbarVisibility(View.GONE)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}