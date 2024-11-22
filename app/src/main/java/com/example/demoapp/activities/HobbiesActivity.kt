package com.example.demoapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demoapp.adapters.HobbiesAdapter
import com.example.demoapp.R
import com.example.demoapp.models.Supplier

class HobbiesActivity : AppCompatActivity() {
    companion object {
        val TAG: String = HobbiesActivity::class.java.simpleName
    }

    lateinit var rvHobby: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hobbies)
        rvHobby = findViewById(R.id.rvHobbies)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        rvHobby.layoutManager = layoutManager

        val adapter = HobbiesAdapter(this, Supplier.hobbies)
        rvHobby.adapter = adapter
    }
}