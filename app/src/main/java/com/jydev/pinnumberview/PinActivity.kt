package com.jydev.pinnumberview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class PinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pin)
        val pin = intent.getStringExtra(MainActivity.PIN_EXTRA)
        findViewById<TextView>(R.id.pin_text).text = pin
    }
}