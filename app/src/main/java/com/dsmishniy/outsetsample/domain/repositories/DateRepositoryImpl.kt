package com.dsmishniy.outsetsample.domain.repositories

import com.dsmishniy.outsetsample.data.repositories.DateRepository
import java.text.SimpleDateFormat
import java.util.*

class DateRepositoryImpl: DateRepository {

    override fun getDate(template: String): String {
        val sdf = SimpleDateFormat(template, Locale.UK)
        val date = Date()
        return sdf.format(date)
    }
}