package com.sandoval.chipperreddittest.presentation.ui.main

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.sandoval.chipperreddittest.R
import com.sandoval.chipperreddittest.presentation.common.BaseActivity

class SplashActivity : BaseActivity() {

    private val SPLASH_TIME_OUT: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler().postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }, SPLASH_TIME_OUT)
    }

    override val layoutResId: Int = R.layout.activity_splash
}