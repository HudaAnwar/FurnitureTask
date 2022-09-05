package com.huda.furnituretask.presentation.ui.saves

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
import com.huda.furnituretask.databinding.FragmentHomeBinding
import com.huda.furnituretask.databinding.SavesFragmentBinding
import com.huda.furnituretask.domain.model.Safe
import com.huda.furnituretask.interfaces.NavigationBarVisibilityListener
import com.huda.furnituretask.presentation.adapters.SavesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SavesFragment : Fragment() {

    private var _binding: SavesFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<SavesViewModel>()
    private val savesList: List<Safe> = listOf()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = SavesFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.topAppBar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        setSavesRecyclerView()
    }

    private fun setSavesRecyclerView() {
        val savesLayoutManager =
            LinearLayoutManager(requireContext())
        val savesAdapter = SavesAdapter(requireContext(), listOf())
        binding.recyclerView.layoutManager = savesLayoutManager
        binding.recyclerView.adapter = savesAdapter

        viewModel.getSaves()
        viewModel.savesLiveData.observe(viewLifecycleOwner) { saves ->
            savesAdapter.updateList(saves)
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
