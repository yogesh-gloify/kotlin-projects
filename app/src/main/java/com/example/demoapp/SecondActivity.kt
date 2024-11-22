package com.example.demoapp

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity(){
    lateinit var tvMessage: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val bundle: Bundle? = intent.extras
        val message = bundle!!.getString("user_message")
        tvMessage = findViewById(R.id.tvMessage)
        tvMessage.text = message
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}