package com.dsmishniy.outsetsample.presentation

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.widget.SeekBar
import androidx.core.graphics.drawable.toDrawable
import androidx.databinding.BindingAdapter
import java.lang.ref.Reference

object BindAdapters {
    @BindingAdapter("app:customProgress")
    @JvmStatic
    fun <T> SeekBar.setDrawableForProgressbar(resource: Reference<T>) {
        val actualResource = resource.get()
        return when (actualResource) {
            is Color -> {
                progressDrawable = actualResource.toDrawable()
            }
            is Drawable -> {
                progressDrawable = actualResource
            }
            else -> this.progressDrawable = null
        }
    }
}

