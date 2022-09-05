package com.huda.furnituretask.presentation.ui.create_account

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.huda.furnituretask.domain.model.Customer
import com.huda.furnituretask.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateAccountViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {
    val customerLiveData = MutableLiveData<Customer?>()
    val registerMessage = MutableLiveData<String?>()

    fun register(
        name: String,
        email: String,
        phone: String,
        address: String,
        password: String,
        passwordConfirmation: String
    ) {
            viewModelScope.launch {
                val res = repository.register(name,email,phone,address,password,passwordConfirmation)
                if (res.isSuccessful) {
                    customerLiveData.value = res.customer
                }
                registerMessage.value = res.message
            }

    }
}