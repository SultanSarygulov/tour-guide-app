package com.example.tourguide

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tourguide.databinding.FragmentShawarmaBinding

class FragmentShawarma : Fragment() {

    private val photo = "https://pbs.twimg.com/ext_tw_video_thumb/1533643804389085185/pu/img/aZFC-czlC1ZLG-hr.jpg"

    private lateinit var binding: FragmentShawarmaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentShawarmaBinding.inflate(inflater, container, false)

        binding.recyclerViewShawarma.layoutManager =
            LinearLayoutManager(this@FragmentShawarma.context)
        binding.recyclerViewShawarma.adapter =
            LocationRecyclerAdapter(shawarmaLocations, "Шаурмячная", photo)
        return binding.root
    }

    private val shawarmaLocations: List<List<String>> = listOf(
        listOf("Oasis", "Московская, 78/1", "Открыто до 22:00"),
        listOf("Эки Дос", "Абдрахманова, 176/5", "Круглосуточно"),
        listOf("Burger na dorojke", "Тунгуч, 36/4", "Круглосуточно"),
        listOf("Muslim Food", "Проспект Ленина, 48", "Открыто до 04:00"),
        listOf("Al-Israa", "Кольбаева, 68", "Открыто до 00:00"),
        listOf("Бир 1/2 Эки", "Проспект Чуй, 110", "Круглосуточно"),
    )
}