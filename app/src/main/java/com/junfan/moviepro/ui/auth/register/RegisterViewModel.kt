package com.junfan.moviepro.ui.auth.register

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.junfan.moviepro.ui.auth.login.LoginActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterViewModel(): ViewModel() {

    var email: String? = null
    var password: String? = null
    var confirmPassword: String? = null
    val msg = MutableLiveData<String>()
    val remember = MutableLiveData<Boolean>(false)

    lateinit var auth: FirebaseAuth

    fun onRegisterButtonClicked(view: View) {
        Log.d("abc", "$email $password $confirmPassword")
        auth = FirebaseAuth.getInstance()
        Log.d("abc", "$email")
        viewModelScope.launch(Dispatchers.IO) {
            if (email.isNullOrEmpty() || password.isNullOrEmpty() || confirmPassword.isNullOrEmpty()) {
                msg.postValue("Please Fill all requested Fields")
            }
            if(password != confirmPassword) {
                msg.postValue("Passwords you entered don't match")
            }
            auth.createUserWithEmailAndPassword(email, password)
        }
    }

    fun rememberMe(view: View) {
        remember.postValue(true)
    }

}