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

    fun startTimeUpdate() {
        val updateTimePeriod = 1000L // 1 second
        timer = fixedRateTimer(period = updateTimePeriod) {
            time.postValue(dateRepository.getDate("E h:mma"))
        }
    }

    fun startCountDown(startTimeInMillis: Long, periodInMillis: Long) {
        val offsetTime = 1000L // 1 second (in some reason, count down timer starts from 5:59,
                                // so I added additional second on start)
        val countDown = object : CountDownTimer(startTimeInMillis + offsetTime, periodInMillis) {
            override fun onFinish() {
                countDownText.postValue("00:00")
            }

            /**
             * Formatting each tick into suitable for displaying form
             * */
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