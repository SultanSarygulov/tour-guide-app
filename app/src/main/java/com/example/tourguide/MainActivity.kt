package com.example.tourguide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tourguide.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val categories = arrayListOf(
        "Шаурмячные",
        "Кофейни",
        "Пиццерии")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tabLayout.tabIconTint = null
        binding.viewPager.adapter = ViewPagerAdapter(this)

        TabLayoutMediator(binding.tabLayout, binding.viewPager){ tab, position ->
            tab.text = categories[position]
        }.attach()
    }
}