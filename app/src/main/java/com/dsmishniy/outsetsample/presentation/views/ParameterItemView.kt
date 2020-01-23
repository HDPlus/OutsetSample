package com.dsmishniy.outsetsample.presentation.views

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.dsmishniy.outsetsample.R
import kotlinx.android.synthetic.main.parameter_item.view.*

class ParameterItemView(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    private lateinit var typedArray: TypedArray

    init {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet) {
        View.inflate(context, R.layout.parameter_item, this)
        typedArray = context
            .theme
            .obtainStyledAttributes(attrs, R.styleable.ParameterItemView, 0, 0)
        try {
            parameter_name.text = typedArray.getText(R.styleable.ParameterItemView_parameterItemName)
            parameter_name.textSize = typedArray.getDimension(R.styleable.ParameterItemView_parameterNameSize, 16f)
            parameter_value.text = typedArray.getText(R.styleable.ParameterItemView_parameterValue)
            parameter_value.textSize = typedArray.getDimension(R.styleable.ParameterItemView_parameterValueSize, 20f)
            parameter_ci.text = typedArray.getText(R.styleable.ParameterItemView_parameterMeasurement)

            this.setBackgroundColor(
                typedArray.getColor(
                    R.styleable.ParameterItemView_itemBackground,
                    context.resources.getColor(R.color.transparent)
                )
            )
        } finally {
            typedArray.recycle()
        }
    }
}