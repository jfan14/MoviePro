package com.junfan.moviepro.ui.auth.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.junfan.moviepro.R
import com.junfan.moviepro.databinding.ActivityLoginBinding
import com.junfan.moviepro.ui.auth.register.RegisterActivity

class LoginActivity : AppCompatActivity() {

    lateinit var loginBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        var view = loginBinding.root
        setContentView(view)

        init()
    }

    fun init() {
        loginBinding.tvToRegister.setOnClickListener {
            var intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}