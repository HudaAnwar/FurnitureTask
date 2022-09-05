package com.huda.furnituretask.presentation.ui.home

import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.huda.furnituretask.R
import com.huda.furnituretask.databinding.FragmentHomeBinding
import com.huda.furnituretask.domain.model.Gallery
import com.huda.furnituretask.domain.model.Offer
import com.huda.furnituretask.interfaces.NavigationBarVisibilityListener
import com.huda.furnituretask.interfaces.OnAdapterItemClickHandler
import com.huda.furnituretask.presentation.adapters.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(), OnAdapterItemClickHandler {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<HomeViewModel>()
    private val bundle = Bundle()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHomeRecyclerViews()
        setGalleriesRecyclerView()

        binding.viewMoreCategories.setOnClickListener {
            findNavController().navigate(R.id.view_categories)
        }
        binding.viewMoreOffers.setOnClickListener {
            findNavController().navigate(R.id.view_offers)
        }
        binding.viewMoreSales.setOnClickListener {
            findNavController().navigate(R.id.view_saves)
        }
        binding.viewMoreDiscounts.setOnClickListener {
            findNavController().navigate(R.id.view_discounts)
        }
        binding.viewMoreNearbyGallaries.setOnClickListener {
            findNavController().navigate(R.id.view_galleries)
        }

    }

    private fun setHomeRecyclerViews() {
        val categoriesAdapter = setCategoriesRecyclerView()
        val branchTypesAdapter = setBranchTypesRecyclerView()
        val savesAdapter = setSavesRecyclerView()
        val discountAdapter = setDiscountsRecyclerView()
        val offersAdapter = setOffersRecyclerView()
        viewModel.getHome()
        viewModel.homeLiveData.observe(viewLifecycleOwner) { home ->
            categoriesAdapter.updateList(home.categories)
            branchTypesAdapter.updateList(home.branchType)
            savesAdapter.updateList(home.saves)
            discountAdapter.updateList(home.discounts)
            offersAdapter.updateList(home.offers)
        }
    }

    private fun setCategoriesRecyclerView(): CategoriesAdapter {
        val layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val categoriesAdapter = CategoriesAdapter(requireContext(), listOf())
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = categoriesAdapter
        return categoriesAdapter
    }

    private fun setOffersRecyclerView(): OffersAdapter {
        val layoutManager =
            LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            )
        val offersAdapter = OffersAdapter(
            requireContext(),
            listOf(),
            this
        )
        binding.offerRecyclerView.layoutManager = layoutManager
        binding.offerRecyclerView.adapter = offersAdapter
        return offersAdapter
    }

    private fun setSavesRecyclerView(): SavesAdapter {
        val savesLayoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val savesAdapter = SavesAdapter(requireContext(), listOf())
        binding.safeRecyclerView.layoutManager = savesLayoutManager
        binding.safeRecyclerView.adapter = savesAdapter
        return savesAdapter
    }

    private fun setDiscountsRecyclerView(): DiscountAdapter {
        val layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val discountAdapter = DiscountAdapter(requireContext(), listOf())
        binding.discountRecyclerView.layoutManager = layoutManager
        binding.discountRecyclerView.adapter = discountAdapter
        return discountAdapter
    }

    private fun setBranchTypesRecyclerView(): BranchTypesAdapter {
        val branchTypeLayoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val branchTypesAdapter = BranchTypesAdapter(requireContext(), listOf())
        binding.branchTypeRecyclerView.layoutManager = branchTypeLayoutManager
        binding.branchTypeRecyclerView.adapter = branchTypesAdapter
        return branchTypesAdapter
    }

    private fun setGalleriesRecyclerView() {
        val galleriesLayoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.galleriesRecyclerView.layoutManager = galleriesLayoutManager
        val galleriesAdapter = GalleriesAdapter(
            requireContext(),
            listOf(),
            0,
            this
        )
        binding.galleriesRecyclerView.adapter = galleriesAdapter
        viewModel.getNearByGalleries(25.2121212, 24.1252152)
        viewModel.galleriesLiveData.observe(viewLifecycleOwner) { galleries ->
            galleriesAdapter.updateList(galleries)
        }

    }

    override fun onStart() {
        super.onStart()
        val navbarActivity = requireActivity() as NavigationBarVisibilityListener
        navbarActivity.navbarVisibility(View.VISIBLE)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClicked(itemId: Int?, type: String) {
        when (type) {
            Gallery::class.simpleName -> {
                bundle.putInt("gallery_id", itemId ?: -1)
                findNavController().navigate(R.id.view_gallery_details, bundle)
            }
            Offer::class.simpleName -> {
                bundle.putInt("offer_id", itemId ?: -1)
                findNavController().navigate(R.id.view_product_details, bundle)
            }
        }

    }
}