package com.sandoval.chipperreddittest.presentation.ui.main

import android.os.Bundle
import com.sandoval.chipperreddittest.R
import kotlinx.android.synthetic.main.activity_main.*
import com.sandoval.chipperreddittest.presentation.common.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbarMain)
    }

    override val layoutResId: Int = R.layout.activity_main
}