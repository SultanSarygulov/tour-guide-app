package com.example.tourguide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter =LocationRecyclerAdapter(getLocationNames())
    }

    private fun getLocationNames(): List<String>{
        return this.resources.getStringArray(R.array.location_names).toList()
    }
}