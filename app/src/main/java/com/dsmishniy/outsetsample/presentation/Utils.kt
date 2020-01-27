package com.dsmishniy.outsetsample.presentation

import android.content.res.Resources
import android.content.res.TypedArray
import android.widget.TextView
import com.dsmishniy.outsetsample.R

const val COUNT_DOWN_START_TIME = 360000L // 6 min in ms

fun TextView.setTextColorFromAttr(styleableId: Int, attrs: TypedArray) {
    val context = this.context
    val color =context.resources.getColor(attrs.getResourceId(styleableId, R.color.colorDark))
    this.setTextColor(color)
}

val Int.dp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()