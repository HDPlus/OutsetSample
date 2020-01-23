package com.dsmishniy.outsetsample.presentation.views

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.core.graphics.drawable.toDrawable
import com.dsmishniy.outsetsample.R
import com.dsmishniy.outsetsample.presentation.setTextColorFromAttr
import kotlinx.android.synthetic.main.progress_bar_item.view.*
import kotlin.math.abs

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
            min_possible.text = typedArray.getText(R.styleable.CustomProgressBar_minRange)
            max_possible.text = maxPossibleToString()
            parameter_name.text = typedArray.getText(R.styleable.CustomProgressBar_parameterName)
            parameter_value.text = typedArray.getText(R.styleable.CustomProgressBar_progress)
            parameter_value.setTextColorFromAttr(
                R.styleable.CustomProgressBar_progressValueColor,
                typedArray
            )

            barSetup(context)

        } finally {
            typedArray.recycle()
        }
    }

    private fun maxPossibleToString(): String {
        val maxRange = typedArray.getInteger(R.styleable.CustomProgressBar_maxRange, 0)
        val measurement = typedArray.getString(R.styleable.CustomProgressBar_measurement)
        return "$maxRange $measurement"
    }

    private fun barSetup(context: Context) {
        bar.max = getMaxRange()
        bar.progress = getProgress()
        bar.progressDrawable =
            typedArray.getDrawable(R.styleable.CustomProgressBar_progressDrawable)
                ?: typedArray.getColor(
                    R.styleable.CustomProgressBar_progressDrawable,
                    context.resources.getColor(R.color.transparent)
                ).toDrawable()
        bar.thumb = typedArray.getDrawable(R.styleable.CustomProgressBar_progressThumb)
        bar.setOnTouchListener { _, _ -> true }
    }

    private fun getMaxRange(): Int {
        val strMaxRange = typedArray.getInteger(R.styleable.CustomProgressBar_maxRange, 0)
        val strMinRange = typedArray.getInteger(R.styleable.CustomProgressBar_minRange, 0)
        return strMaxRange - strMinRange
    }

    private fun getProgress(): Int {
        val strProgress = typedArray.getInteger(R.styleable.CustomProgressBar_progress, 0)
        val strMinRange = typedArray.getInteger(R.styleable.CustomProgressBar_minRange, 0)
        return when {
            strMinRange < 0 -> abs(strMinRange) + strProgress
            strMinRange > 0 -> strProgress - strMinRange
            else -> strProgress
        }
    }
}