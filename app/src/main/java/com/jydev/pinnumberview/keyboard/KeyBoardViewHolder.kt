package com.jydev.pinnumberview.keyboard

import androidx.recyclerview.widget.RecyclerView
import com.jydev.pinnumberview.databinding.ItemKeyBoardBinding

class KeyBoardViewHolder(
    private val binding: ItemKeyBoardBinding,
    private val backClick: () -> Unit,
    private val numberClick: (number: String) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(key: String) {
        binding.keyTextView.text = key
        binding.root.setOnClickListener {
            if (key.isNotEmpty()) {
                when (key) {
                    "back" -> backClick()
                    else -> numberClick(key)
                }
            }
        }
    }
}