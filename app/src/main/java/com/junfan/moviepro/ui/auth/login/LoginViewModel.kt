package com.junfan.moviepro.ui.auth.login

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {

    var email: String? = null
    var password: String? = null
    val msg = MutableLiveData<String>()
    val remember = MutableLiveData<Boolean>(false)

    fun rememberMe(view: View) {
        remember.postValue(true)
    }

    fun login(view: View) {
        viewModelScope.launch(Dispatchers.IO) {
            if(email.isNullOrEmpty() || password.isNullOrEmpty()) {
                msg.postValue("Please fill all required fields")
            }
        }
    }
}