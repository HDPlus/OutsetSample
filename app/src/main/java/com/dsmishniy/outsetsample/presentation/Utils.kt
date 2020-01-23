package com.dsmishniy.outsetsample.presentation

import android.content.res.TypedArray
import android.widget.TextView
import com.dsmishniy.outsetsample.R

fun TextView.setTextColorFromAttr(styleableId: Int, attrs: TypedArray) {
    val context = this.context
    val color =context.resources.getColor(attrs.getResourceId(styleableId, R.color.colorDark))
    this.setTextColor(color)
}