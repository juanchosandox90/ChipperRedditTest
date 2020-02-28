package com.sandoval.chipperreddittest.presentation.util.extension

import android.view.View
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import androidx.core.view.isVisible

fun View.visible() {
    this.isVisible = true
}

fun View.invisible() {
    this.isInvisible = true
}

fun View.gone() {
    this.isGone = true
}

infix fun View.onClick(block: (View) -> Unit) {
    this.setOnClickListener { block(it) }
}