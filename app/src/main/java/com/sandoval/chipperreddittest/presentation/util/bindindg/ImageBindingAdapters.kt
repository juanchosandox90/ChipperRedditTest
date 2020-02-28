package com.sandoval.chipperreddittest.presentation.util.bindindg

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.sandoval.chipperreddittest.presentation.util.GlideApp
import com.sandoval.chipperreddittest.presentation.util.extension.gone

object ImageBindingAdapters {
    @JvmStatic
    @BindingAdapter("app:image")
    fun loadImage(view: ImageView, imagePath: String?) {
        GlideApp.with(view.context)
            .load(imagePath)
            .centerCrop()
            .transition(withCrossFade())
            .listener(getListener(view))
            .apply(RequestOptions.bitmapTransform(RoundedCorners(2)))
            .into(view)
    }

    @JvmStatic
    @BindingAdapter("app:circle_image")
    fun loadCircleImage(view: ImageView, imagePath: String) {
        GlideApp.with(view.context)
            .load(imagePath)
            .centerCrop()
            .transition(withCrossFade())
            .listener(getListener(view))
            .apply(RequestOptions.circleCropTransform())
            .into(view)
    }

    private fun getListener(view: ImageView) = object : RequestListener<Drawable?> {
        override fun onLoadFailed(
            e: GlideException?,
            model: Any?,
            target: Target<Drawable?>?,
            isFirstResource: Boolean
        ): Boolean {
            view.gone()
            return false
        }

        override fun onResourceReady(
            resource: Drawable?,
            model: Any?,
            target: Target<Drawable?>?,
            dataSource: DataSource?,
            isFirstResource: Boolean
        ): Boolean {
            return false
        }
    }
}