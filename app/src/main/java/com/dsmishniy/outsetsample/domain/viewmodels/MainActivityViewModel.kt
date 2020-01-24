package com.dsmishniy.outsetsample.domain.viewmodels

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dsmishniy.outsetsample.data.repositories.DateRepository
import com.dsmishniy.outsetsample.data.repositories.ParameterItemRepository
import com.dsmishniy.outsetsample.domain.repositories.DateRepositoryImpl
import com.dsmishniy.outsetsample.domain.repositories.ParameterItemRepoImpl
import java.util.*
import kotlin.concurrent.fixedRateTimer


class MainActivityViewModel : ViewModel() {

    val time = MutableLiveData<String>()
    val countDownText = MutableLiveData<String>()

    private lateinit var timer: Timer
    private val dateRepository: DateRepository = DateRepositoryImpl()
    private val parameterItemRepository: ParameterItemRepository = ParameterItemRepoImpl()

    fun getTime() {
        timer = fixedRateTimer(period = 1000) {
            time.postValue(dateRepository.getDate("E HH:mma"))
        }
    }

    fun startCountDown(startTimeInMillis: Long, periodInMillis: Long) {
        val countDown = object : CountDownTimer(startTimeInMillis + 1000, periodInMillis) {
            override fun onFinish() {
                countDownText.postValue("00:00")
            }

            override fun onTick(millisUntilFinished: Long) {
                val minutes = millisUntilFinished / 1000 / 60
                val seconds = millisUntilFinished / 1000 % 60

                val formattedTime = String.format(Locale.UK, "%02d:%02d", minutes, seconds)
                countDownText.postValue(formattedTime)
            }

        }
        countDown.start()
    }

    fun getInfoItems() = parameterItemRepository.getParameterItems()

    fun disableTimer() {
        timer.cancel()
        timer.purge()
    }
}