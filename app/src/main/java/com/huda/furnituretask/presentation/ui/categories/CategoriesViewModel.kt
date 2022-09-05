package com.huda.furnituretask.presentation.ui.categories

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.huda.furnituretask.domain.model.FurnitureCategory
import com.huda.furnituretask.domain.model.Home
import com.huda.furnituretask.repository.FurnitureRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(
    private val repository: FurnitureRepository
) : ViewModel() {
    val categoriesLiveData = MutableLiveData<List<FurnitureCategory>>()
    val errorMsg = MutableLiveData<String>()
    fun getCategories() {
        viewModelScope.launch {
            val res = repository.getCategories()
            res?.let { result ->
                categoriesLiveData.value = result
            } ?: run {
                errorMsg.value = "No Data found"
            }
        }
    }
}