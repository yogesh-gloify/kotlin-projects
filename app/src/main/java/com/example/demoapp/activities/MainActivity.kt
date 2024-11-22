package com.example.demoapp.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.demoapp.R
import com.example.demoapp.showToast

class MainActivity : AppCompatActivity() {
    lateinit var btnShowMsg: Button
    lateinit var btnGoToNextActivity: Button
    lateinit var etMessage: EditText
    lateinit var btnShareToNetwork: Button
    lateinit var btnRecyclerViewDemo: Button

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
        btnRecyclerViewDemo = findViewById(R.id.btnRecyclerViewDemo)

        btnShowMsg.setOnClickListener {
            Log.i("MainActivity", "Button clicked!")
            showToast("Button clicked!")
        }

        btnGoToNextActivity.setOnClickListener {
            val message: String = etMessage.text.toString()
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("user_message", message)
            startActivity(intent)
        }

        btnShareToNetwork.setOnClickListener {
            val message: String = etMessage.text.toString()
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, "Share to Your Network"))
        }

        btnRecyclerViewDemo.setOnClickListener {
            val intent = Intent(this, HobbiesActivity::class.java)
            startActivity(intent)
        }
    }
}