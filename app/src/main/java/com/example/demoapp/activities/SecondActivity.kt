package com.example.demoapp.activities

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.demoapp.R
import com.example.demoapp.showToast

class SecondActivity : AppCompatActivity(){
    lateinit var tvMessage: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val bundle: Bundle? = intent.extras
        bundle?.let {
            val message = bundle.getString("user_message")
            tvMessage = findViewById(R.id.tvMessage)
            tvMessage.text = message
            showToast(message.toString())
        }
    }
}