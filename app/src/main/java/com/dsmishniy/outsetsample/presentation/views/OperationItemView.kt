package com.dsmishniy.outsetsample.presentation.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.dsmishniy.outsetsample.R
import kotlinx.android.synthetic.main.operation_btn_item.view.*

class OperationItemView(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    init {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet) {
        View.inflate(context, R.layout.operation_btn_item, this)
        val typedArray = context
            .theme
            .obtainStyledAttributes(attrs, R.styleable.OperationItemView, 0, 0)
        operation_btn_img.setImageResource(
            typedArray.getResourceId(
                R.styleable.OperationItemView_buttonImageSrc,
                R.color.transparent
            )
        )
        operation_btn_title.text = typedArray.getText(R.styleable.OperationItemView_operationName)
        operation_btn_title.setTextColor(
            typedArray.getColor(
                R.styleable.OperationItemView_operationNameColor,
                context.resources.getColor(R.color.colorDark)
            )
        )
    }
}