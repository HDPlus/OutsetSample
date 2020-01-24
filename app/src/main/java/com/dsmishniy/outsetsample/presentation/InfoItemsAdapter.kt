package com.dsmishniy.outsetsample.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dsmishniy.outsetsample.R
import com.dsmishniy.outsetsample.data.entities.ParameterItem

class InfoItemsAdapter : RecyclerView.Adapter<InfoItemsAdapter.InfoItemViewHolder>() {

    private val items = mutableListOf<ParameterItem>()
    private var tappedItem = -1

    fun addItems(items: List<ParameterItem>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoItemViewHolder {
        val row = LayoutInflater.from(parent.context).inflate(R.layout.info_item, parent, false)
        return InfoItemViewHolder(row)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: InfoItemViewHolder, position: Int) {
        holder.bind(items[position])
        holder.itemView.setOnClickListener {
            tappedItem = position
            notifyDataSetChanged()
        }

        val context = holder.itemView.context
        if (position == tappedItem) {
            holder.itemView.setBackgroundColor(context.resources.getColor(R.color.colorDirtBlue))
        } else {
            holder.itemView.setBackgroundColor(context.resources.getColor(R.color.colorWhite))
        }
    }

    class InfoItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val parameterName = itemView.findViewById<TextView>(R.id.parameter_name)
        private val parameterValue = itemView.findViewById<TextView>(R.id.parameter_value)
        private val parameterMeasurement = itemView.findViewById<TextView>(R.id.parameter_ci)

        fun bind(item: ParameterItem) {
            parameterName.text = item.parameterName
            parameterValue.text = item.parameterValue
            parameterMeasurement.text = item.measurement
        }
    }
}