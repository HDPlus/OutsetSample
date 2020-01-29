package com.dsmishniy.outsetsample.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.dsmishniy.outsetsample.R
import com.dsmishniy.outsetsample.domain.viewmodels.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_dashboard.*


class MainActivity : AppCompatActivity(), ViewModelStoreOwner {

    private lateinit var model: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        model = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory(application)
        )[MainActivityViewModel::class.java]

        getTime()
        startCountDown()

        val infoItemsAdapter = InfoItemsAdapter()
        infoItemsAdapter.addItems(model.getInfoItems())
        info_items.layoutManager = LinearLayoutManager(this)
        info_items.adapter = infoItemsAdapter

        switch_cards_btn.setOnClickListener {
            if (info_card.isVisible && info_items.isVisible) {
                info_card.visibility = View.GONE
                info_items.visibility = View.GONE
                hidden_cards.visibility = View.VISIBLE
                switch_cards_btn.setImageResource(R.drawable.ic_open_cards)
            } else {
                info_card.visibility = View.VISIBLE
                info_items.visibility = View.VISIBLE
                hidden_cards.visibility = View.GONE
                switch_cards_btn.setImageResource(R.drawable.ic_close_cards)
            }
        }
    }

    private fun getTime() {
        model.startTimeUpdate()
        model.time.observe(this, Observer {
            clock.text = it
        })
    }

    private fun startCountDown() {
        model.startCountDown(COUNT_DOWN_START_TIME, 1000)
        model.countDownText.observe(this, Observer {
            timer.text = it
        })
    }

    override fun onDestroy() {
        model.disableTimer()
        super.onDestroy()
    }
}
