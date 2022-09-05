package com.huda.furnituretask.presentation.ui.galleries

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.huda.furnituretask.domain.model.Gallery
import com.huda.furnituretask.repository.FurnitureRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GalleriesViewModel @Inject constructor(
    private val repository: FurnitureRepository
) : ViewModel() {

    val galleriesLiveData = MutableLiveData<List<Gallery>>()
    val errorMsg = MutableLiveData<String>()
    fun getGalleries(lat:Double,lng:Double){
        viewModelScope.launch {
            val res = repository.getNearByGalleries(lat,lng)
            if (res.isNotEmpty()) {
                galleriesLiveData.value = res
            }else{
                errorMsg.value = "No galleries found"
            }
        }
    }
}