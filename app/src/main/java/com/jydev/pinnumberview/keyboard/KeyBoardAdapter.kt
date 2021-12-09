package com.jydev.pinnumberview.keyboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jydev.pinnumberview.databinding.ItemKeyBoardBinding

class KeyBoardAdapter(
    private val backClick: () -> Unit,
    private val numberClick: (number: String) -> Unit
) : RecyclerView.Adapter<KeyBoardViewHolder>() {
    private val keyList = arrayOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "", "0", "back")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KeyBoardViewHolder =
        KeyBoardViewHolder(
            ItemKeyBoardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), backClick, numberClick
        )

    override fun onBindViewHolder(holder: KeyBoardViewHolder, position: Int) {
        holder.bind(keyList[position])
    }

    override fun getItemCount(): Int =
        keyList.size
}