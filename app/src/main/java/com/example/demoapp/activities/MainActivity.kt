package com.example.demoapp.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.demoapp.R
import com.example.demoapp.showToast
import java.util.Locale

class MainActivity : AppCompatActivity() {
    lateinit var btnShowMsg: Button
    lateinit var btnGoToNextActivity: Button
    lateinit var etMessage: EditText
    lateinit var btnShareToNetwork: Button
    lateinit var btnRecyclerViewDemo: Button
    lateinit var btnChangeLanguage: Button
    lateinit var switchTheme: Switch
    private lateinit var sharedPref: SharedPreferences

    private fun setLocale(languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val config = Configuration()
        config.setLocale(locale)
        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)
    }

    private fun setTheme(isDarkTheme: Boolean) {
        if(isDarkTheme) {
            switchTheme.isChecked = true
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            switchTheme.text = resources.getString(R.string.theme_dark)
        } else {
            switchTheme.isChecked = false
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            switchTheme.text = resources.getString(R.string.theme_light)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        sharedPref = getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        btnShowMsg = findViewById(R.id.btnShowMsg)
        btnGoToNextActivity = findViewById(R.id.btnGoToNextActivity)
        etMessage = findViewById(R.id.etMessage)
        btnShareToNetwork = findViewById(R.id.btnShareToNetwork)
        btnRecyclerViewDemo = findViewById(R.id.btnRecyclerViewDemo)
        btnChangeLanguage = findViewById(R.id.btnChangeLanguage)
        switchTheme = findViewById(R.id.switchTheme)

        val language: String = sharedPref.getString("language", resources.configuration.locales[0].language)!!.toString()
        setLocale(language)
        val isDarkTheme: Boolean = sharedPref.getBoolean("dark_theme", false)
        setTheme(isDarkTheme)


        btnShowMsg.setOnClickListener {
            Log.i("MainActivity", "Button clicked!")
            showToast(resources.getString(R.string.toast_btn_clicked))
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
            startActivity(
                Intent.createChooser(
                    intent,
                    resources.getString(R.string.btn_share_to_your_network)
                )
            )
        }

        btnRecyclerViewDemo.setOnClickListener {
            val intent = Intent(this, HobbiesActivity::class.java)
            startActivity(intent)
        }

        btnChangeLanguage.setOnClickListener {
            val currentLocale: Locale = resources.configuration.locales[0]
            val languageCode: String = currentLocale.language
            if (languageCode == "hi") {
                setLocale("en")
                editor.putString("language", "en")
                editor.apply()
            } else {
                setLocale("hi")
                editor.putString("language", "hi")
                editor.apply()
            }
            recreate()
        }
        switchTheme.setOnClickListener {
            if (switchTheme.isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                switchTheme.text = resources.getString(R.string.theme_dark)
                editor.putBoolean("dark_theme", true)
                editor.apply()
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                switchTheme.text = resources.getString(R.string.theme_light)
                editor.putBoolean("dark_theme", false)
                editor.apply()
            }

        }
    }
}