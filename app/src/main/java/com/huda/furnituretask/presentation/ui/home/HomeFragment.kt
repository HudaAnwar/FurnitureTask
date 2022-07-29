package com.huda.furnituretask.presentation.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.huda.furnituretask.R
import com.huda.furnituretask.databinding.FragmentHomeBinding
import com.huda.furnituretask.databinding.FragmentLoginBinding
import com.huda.furnituretask.interfaces.NavigationBarVisibilityListener
import com.huda.furnituretask.presentation.adapters.CategoriesAdapter
import com.huda.furnituretask.util.Constants


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        val adapter = CategoriesAdapter(requireContext(),Constants.furnitureTypeNames)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter
//        binding.forgotPassword.setOnClickListener {
//            findNavController().navigate(R.id.backToLogin_test)
//        }
    }
    override fun onStart() {
        super.onStart()
        val navbarActivity = requireActivity() as NavigationBarVisibilityListener
        navbarActivity.navbarVisibility(View.VISIBLE)
    }
}