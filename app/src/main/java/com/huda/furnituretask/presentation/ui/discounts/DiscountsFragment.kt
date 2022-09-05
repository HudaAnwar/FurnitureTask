package com.huda.furnituretask.presentation.ui.discounts

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.huda.furnituretask.R
import com.huda.furnituretask.databinding.DiscountsFragmentBinding
import com.huda.furnituretask.interfaces.NavigationBarVisibilityListener
import com.huda.furnituretask.presentation.adapters.DiscountAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DiscountsFragment : Fragment() {
    private val viewModel by viewModels<DiscountsViewModel>()
    private var _binding: DiscountsFragmentBinding? = null
    private val binding get() = _binding!!
    private val discountsList = listOf("10 جنيه", "20 جنيه", "30 جنيه", "40 جنيه")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DiscountsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.topAppBar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        setDiscountsRecyclerView()
    }

    private fun setDiscountsRecyclerView() {
        val layoutManager =
            LinearLayoutManager(requireContext())
        val discountAdapter = DiscountAdapter(requireContext(), listOf())
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = discountAdapter
        viewModel.getDiscounts()
        viewModel.discountsLiveData.observe(viewLifecycleOwner) { discounts ->
            discountAdapter.updateList(discounts)
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