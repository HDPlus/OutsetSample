package com.dsmishniy.outsetsample.data

interface DateRepository {
    fun getDate(template: String): String
}