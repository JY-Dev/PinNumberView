package com.jydev.pinnumberview.pinnumber

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jydev.pinnumberview.databinding.ItemPinNumberBinding

class PinNumberAdapter : RecyclerView.Adapter<PinNumberViewHolder>() {
    private val pinInputStatusArray = Array(PIN_COUNT){false}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PinNumberViewHolder =
        PinNumberViewHolder(ItemPinNumberBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: PinNumberViewHolder, position: Int) {
        holder.bind(pinInputStatusArray[position])
    }

    override fun getItemCount(): Int =
        PIN_COUNT

    fun updatePin(pinNumberSize : Int){
        for(i in 1..PIN_COUNT)
            pinInputStatusArray[i-1] = (i<=pinNumberSize)
        notifyDataSetChanged()
    }

    companion object{
        const val PIN_COUNT = 6
    }
}