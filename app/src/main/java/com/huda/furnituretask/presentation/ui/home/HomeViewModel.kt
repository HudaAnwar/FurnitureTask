package com.huda.furnituretask.presentation.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.huda.furnituretask.domain.model.FurnitureCategory
import com.huda.furnituretask.domain.model.Gallery
import com.huda.furnituretask.domain.model.Home
import com.huda.furnituretask.repository.FurnitureRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: FurnitureRepository
) : ViewModel() {
    val homeLiveData = MutableLiveData<Home>()
    val galleriesLiveData = MutableLiveData<List<Gallery>>()
    val errorMsg = MutableLiveData<String>()
    fun getHome() {
        viewModelScope.launch {
            val res = repository.getHome()
            res?.let { result ->
                homeLiveData.value = result
            } ?: run {
                errorMsg.value = "No Data found"
            }
        }
    }

    fun getNearByGalleries(lat: Double, lng: Double) {
        viewModelScope.launch {
            val res = repository.getNearByGalleries(lat, lng)
            if (res.isNotEmpty()) {
                galleriesLiveData.value = res
            }else{
                errorMsg.value = "No galleries found"
            }
        }
    }
}