package com.dsmishniy.outsetsample.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelStoreOwner
import com.dsmishniy.outsetsample.R
import kotlinx.android.synthetic.main.main_dashboard.*


class MainActivity : AppCompatActivity(), ViewModelStoreOwner {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //todo add view model call

        switch_cards_btn.setOnClickListener {
            if(info_card.isVisible && info_items.isVisible) {
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
}
