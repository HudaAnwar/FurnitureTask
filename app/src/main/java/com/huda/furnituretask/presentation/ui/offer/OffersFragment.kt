package com.huda.furnituretask.presentation.ui.offer

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.state.ToggleableState
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.huda.furnituretask.R
import com.huda.furnituretask.databinding.OffersFragmentBinding
import com.huda.furnituretask.domain.model.Offer
import com.huda.furnituretask.interfaces.NavigationBarVisibilityListener
import com.huda.furnituretask.interfaces.OnAdapterItemClickHandler
import com.huda.furnituretask.presentation.adapters.OffersAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OffersFragment : Fragment(), OnAdapterItemClickHandler {
    private val viewModel by viewModels<OffersViewModel>()
    private var _binding: OffersFragmentBinding? = null
    private val binding get() = _binding!!
    private val bundle = Bundle()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = OffersFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.topAppBar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        setOffersRecyclerView()
    }

    override fun onStart() {
        super.onStart()
        val navbarActivity = requireActivity() as NavigationBarVisibilityListener
        navbarActivity.navbarVisibility(View.GONE)
    }

    private fun setOffersRecyclerView() {
        val layoutManager =
            LinearLayoutManager(requireContext())
        val offersAdapter = OffersAdapter(requireContext(), listOf(), this)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = offersAdapter
        viewModel.getOffers()
        viewModel.offersLiveData.observe(viewLifecycleOwner) { offers ->
            offersAdapter.updateList(offers)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClicked(itemId: Int?, type: String) {
        bundle.putInt("offer_id", itemId ?: -1)
        findNavController().navigate(R.id.view_product_details, bundle)
    }
}