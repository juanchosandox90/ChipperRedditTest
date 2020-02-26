package com.sandoval.chipperreddittest

import android.os.Bundle
import com.sandoval.chipperreddittest.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbarMain)
    }

    override val layoutResId: Int = R.layout.activity_main
}
