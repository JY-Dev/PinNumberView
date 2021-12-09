package com.jydev.pinnumberview.pinnumber

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jydev.pinnumberview.databinding.PinNumberViewBinding
import java.lang.StringBuilder

class PinNumberView @JvmOverloads constructor(context: Context, attrs : AttributeSet? = null) : LinearLayout(context, attrs) {
    private val binding : PinNumberViewBinding = PinNumberViewBinding.inflate(LayoutInflater.from(context),this,false).also {
        addView(it.root)
    }
    private val _isComplete = MutableLiveData<String>()
    val isComplete : LiveData<String> = _isComplete
    private val pin = StringBuilder()
    private val pinNumberAdapter : PinNumberAdapter = PinNumberAdapter()
    init {
        with(binding.pinNumberRecyclerview){
            adapter = pinNumberAdapter
        }
    }

    fun setPinNumber(number : String){
        pin.append(number)
        updatePin()
        if(isPinComplete())
            _isComplete.value = pin.toString()
    }

    fun removePinNumber(){
        if(pin.isNotEmpty())
           pin.setLength(pin.length-1)
        updatePin()
    }

    fun clearPin(){
        pin.clear()
        updatePin()
    }

    private fun updatePin(){
        pinNumberAdapter.updatePin(pin.length)
    }

    private fun isPinComplete() =
        pin.length == PinNumberAdapter.PIN_COUNT

}