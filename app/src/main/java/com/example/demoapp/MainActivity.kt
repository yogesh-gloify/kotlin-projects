package com.example.demoapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var btnShowMsg: Button
    lateinit var btnGoToNextActivity: Button
    lateinit var etMessage: EditText
    lateinit var btnShareToNetwork : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnShowMsg = findViewById(R.id.btnShowMsg)
        btnGoToNextActivity = findViewById(R.id.btnGoToNextActivity)
        etMessage = findViewById(R.id.etMessage)
        btnShareToNetwork = findViewById(R.id.btnShareToNetwork)

        btnShowMsg.setOnClickListener {
            Log.i("MainActivity", "Button clicked!")
            Toast.makeText(this, "Button clicked!", Toast.LENGTH_SHORT).show()
        }

        btnGoToNextActivity.setOnClickListener {
            val message : String = etMessage.text.toString()
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("user_message", message)
            startActivity(intent)
        }

        btnShareToNetwork.setOnClickListener {
            val message : String = etMessage.text.toString()
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, "Share to Your Network"))
        }
    }
}