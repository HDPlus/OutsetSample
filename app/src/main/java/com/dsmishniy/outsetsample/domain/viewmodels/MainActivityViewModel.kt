package com.dsmishniy.outsetsample.domain.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dsmishniy.outsetsample.data.DateRepository
import com.dsmishniy.outsetsample.domain.DateRepositoryImpl
import java.util.*
import kotlin.concurrent.fixedRateTimer


class MainActivityViewModel : ViewModel() {

    private val time = MutableLiveData<String>()
    private lateinit var timer: Timer
    private val dateRepository: DateRepository = DateRepositoryImpl()

    fun getTime() {
        timer = fixedRateTimer(period = 1000) {
            time.postValue(dateRepository.getDate("E KK:mma"))
        }
    }

    fun disableTimer() {
        timer.cancel()
        timer.purge()
    }
}