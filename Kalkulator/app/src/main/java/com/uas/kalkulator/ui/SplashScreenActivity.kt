package com.uas.kalkulator.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.uas.kalkulator.R

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        supportActionBar?.hide()

        Handler(mainLooper).postDelayed({
            Intent(this, HomeActivity::class.java).apply {
                startActivity(this)
                finish()
            }
        }, SPLASH_TIME_OUT)
    }
}

const val SPLASH_TIME_OUT = 3000L