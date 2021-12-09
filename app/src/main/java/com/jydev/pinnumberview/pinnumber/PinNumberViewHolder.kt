package com.jydev.pinnumberview.pinnumber

import androidx.recyclerview.widget.RecyclerView
import com.jydev.pinnumberview.databinding.ItemPinNumberBinding

class PinNumberViewHolder(private val binding : ItemPinNumberBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(isInput : Boolean){
        binding.pinImage.isEnabled = isInput
    }
}