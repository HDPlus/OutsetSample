package com.dsmishniy.outsetsample.data.repositories

interface DateRepository {
    fun getDate(template: String): String
}