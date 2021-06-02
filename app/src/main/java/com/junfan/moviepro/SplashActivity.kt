package com.junfan.moviepro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.junfan.moviepro.ui.auth.register.RegisterActivity

class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIME = 3000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            var intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_TIME)
    }
}