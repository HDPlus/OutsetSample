package com.dsmishniy.outsetsample.presentation.views

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.dsmishniy.outsetsample.R
import kotlinx.android.synthetic.main.progress_bar_item.view.*

class CustomProgressBar(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    private lateinit var typedArray: TypedArray


    init {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet) {
        View.inflate(context, R.layout.progress_bar_item, this)
        typedArray = context
            .theme
            .obtainStyledAttributes(attrs, R.styleable.CustomProgressBar, 0, 0)
        try {
            min_possible.text = typedArray.getInteger(R.styleable.CustomProgressBar_minRange, 0).toString()

        } finally {
            typedArray.recycle()
        }
    }

    private fun barSetup() {
        bar.max = typedArray.getInteger(R.styleable.CustomProgressBar_maxRange, 0)
        bar.progress = typedArray.getInteger(R.styleable.CustomProgressBar_progress, 0)
        bar.progressDrawable.apply {
            val resource = typedArray.getResourceId(R.styleable.CustomProgressBar_progressDrawable, -1)
            //todo check resource color or drawable
        }
    }
}