package com.jydev.pinnumberview

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import com.jydev.pinnumberview.databinding.ActivityMainBinding
import com.jydev.pinnumberview.keyboard.KeyBoardAdapter

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val backClick: () -> Unit = {
        binding.pinNumberView.removePinNumber()
    }
    private val numberClick: (String) -> Unit = { number ->
        binding.pinNumberView.setPinNumber(number = number)
    }
    private val keyBoardAdapter: KeyBoardAdapter by lazy {
        KeyBoardAdapter(backClick, numberClick)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() =
        with(binding) {
            setKeyboard()
            pinNumberView.isComplete.observe(this@MainActivity){ pin ->
                pinNumberView.clearPin()
                startActivity(Intent(this@MainActivity,PinActivity::class.java).apply {
                    putExtra(PIN_EXTRA,pin)
                })
            }
        }

    private fun ActivityMainBinding.setKeyboard() =
        with(keyboard) {
            addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    DividerItemDecoration.VERTICAL
                )
            )
            addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    DividerItemDecoration.HORIZONTAL
                )
            )
            adapter = keyBoardAdapter
        }

    companion object{
        const val PIN_EXTRA = "pinExtra"
    }
}