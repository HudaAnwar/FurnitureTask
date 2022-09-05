package com.huda.furnituretask.presentation.ui.discounts

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.huda.furnituretask.domain.model.Discount
import com.huda.furnituretask.repository.FurnitureRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DiscountsViewModel @Inject constructor(
    private val repository: FurnitureRepository
) : ViewModel() {
    val discountsLiveData = MutableLiveData<List<Discount>>()

    fun getDiscounts() {
        viewModelScope.launch {
            val res = repository.getDiscounts()
            discountsLiveData.value = res
        }
    }
    // TODO: Implement the ViewModel
}