package com.dsmishniy.outsetsample.data.entities

data class ParameterItem(
    val parameterName: String,
    val parameterValue: String,
    val measurement: String? = null,
    val additionalInfo: Boolean = false
)