package com.huda.furnituretask.presentation.ui.galleries.gallery_details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.huda.furnituretask.domain.model.Gallery
import com.huda.furnituretask.domain.model.GalleryDetails
import com.huda.furnituretask.repository.FurnitureRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GalleryDetailsViewModel @Inject constructor(
    private val repository: FurnitureRepository
) : ViewModel() {

    val galleryDetailsLiveData = MutableLiveData<GalleryDetails>()

    fun getGalleryDetails(id: Int) {
        viewModelScope.launch {
            val res = repository.getGalleryDetails(id)
            galleryDetailsLiveData.value = res
        }
    }
}