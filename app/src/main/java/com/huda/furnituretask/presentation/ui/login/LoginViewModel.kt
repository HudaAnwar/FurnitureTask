package com.huda.furnituretask.presentation.ui.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.huda.furnituretask.domain.model.Customer
import com.huda.furnituretask.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {
    val customer = MutableLiveData<Customer?>()
    val loginMessage = MutableLiveData<String?>()
    val isUsernameOrPasswordEmpty = MutableLiveData<String>()

    fun login(username: String?, password: String?) {
        if (!username.isNullOrEmpty()) {
            viewModelScope.launch {
                val res = repository.login(username, password!!)
                if (res.isSuccessful) {
                    customer.value = res.customer
                    loginMessage.value = res.message
                } else {
                    isUsernameOrPasswordEmpty.value = "إسم المستخدم أو كلمة المرور خاطئة"
                }

            }
        } else {
            isUsernameOrPasswordEmpty.value = "إسم المستخدم أو كلمة المرور خاطئة"
        }
    }

    fun checkSocialLogin(
        providerType: String,
        providerId: String?,
        name: String,
        email: String
    ) {
        if (!providerId.isNullOrEmpty()) {
            viewModelScope.launch {
                val res = repository.checkSocialLogin(providerType, providerId)
                if (res.isSuccessful) {
                    customer.value = res.customer
                    loginMessage.value = res.message
                } else {
                    socialLogin(providerType, providerId, name, email)
                }

            }
        } else {
            isUsernameOrPasswordEmpty.value = "provider id is null"
        }
    }

    private fun socialLogin(providerType: String, providerId: String?, name: String, email: String) {
        if (!providerId.isNullOrEmpty()) {
            viewModelScope.launch {
                val res = repository.socialLogin(providerType, providerId, name, email)
                if (res.isSuccessful) {
                    customer.value = res.customer
                    loginMessage.value = res.message
                } else {
                    isUsernameOrPasswordEmpty.value =
                        "حد خطأ ما عند تسجيل الدخول بحساب $providerType"
                }

            }
        } else {
            isUsernameOrPasswordEmpty.value = "provider id is null"
        }
    }
}