package com.huda.furnituretask.presentation.ui.saves

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.huda.furnituretask.domain.model.Safe
import com.huda.furnituretask.repository.FurnitureRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SavesViewModel @Inject constructor(
    private val repository: FurnitureRepository
) : ViewModel() {
    val savesLiveData = MutableLiveData<List<Safe>>()

    fun getSaves() {
        viewModelScope.launch {
            val res = repository.getSaves()
            savesLiveData.value = res
        }
    }
}