package com.huda.furnituretask.presentation.ui.offer

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.huda.furnituretask.domain.model.Offer
import com.huda.furnituretask.repository.FurnitureRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OffersViewModel @Inject constructor(
    private val repository: FurnitureRepository
) : ViewModel() {
    val offersLiveData = MutableLiveData<List<Offer>>()
    fun getOffers() {
        viewModelScope.launch {
            val res = repository.getOffers()
            offersLiveData.value = res
        }
    }

}