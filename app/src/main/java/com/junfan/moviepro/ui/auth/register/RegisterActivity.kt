package com.junfan.moviepro.ui.auth.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.junfan.moviepro.R
import com.junfan.moviepro.databinding.ActivityRegisterBinding
import com.junfan.moviepro.ui.auth.login.LoginActivity

class RegisterActivity : AppCompatActivity() {

    lateinit var registerBinding: ActivityRegisterBinding
    lateinit var viewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerBinding = DataBindingUtil.setContentView(this, R.layout.activity_register)
        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
        registerBinding.registerBinding = viewModel
        var view = registerBinding.root
        setContentView(view)

        init()
    }

    fun init() {

        setUpObserver()

        registerBinding.tvToLogin.setOnClickListener {
            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }

    private fun setUpObserver() {
        viewModel.msg.observe(this){
            Toast.makeText(applicationContext, it, Toast.LENGTH_LONG).show()
        }
    }

    /*fun onRegisterClicked(view: View) {
        viewModel.onRegisterButtonClicked()
    }*/
}