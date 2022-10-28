package com.example.tourguide

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tourguide.databinding.FragmentShawarmaBinding

class FragmentShawarma : Fragment() {

    private val photo = "https://avatars.mds.yandex.net/get-altay/1705560/2a0000016c8cceb4fd49483a33fbbdde78d4/XXL"

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
        listOf("Oasis", "Московская, 78/1", "Открыто до 22:00", "Киоск фастфудной продукции", "250", "+996 774‒44‒55‒99"),
        listOf("Эки Дос", "Абдрахманова, 176/5", "Круглосуточно", "Кафе быстрого питания", "130", "+996 509‒82‒28‒22"),
        listOf("Burger na dorojke", "Тунгуч, 36/4", "Круглосуточно", "Киоск фастфудной продукции", "150", "+996 555‒16‒16‒51"),
        listOf("Muslim Food", "Проспект Ленина, 48", "Открыто до 04:00", "Киоск фастфуда", "150", "Отсутствует"),
        listOf("Al-Israa", "Кольбаева, 68", "Открыто до 00:00", "Киоск фастфудной продукции", "700", "+996 703‒33‒37‒13"),
        listOf("Бир 1/2 Эки", "Проспект Чуй, 110", "Круглосуточно", "Кафе быстрого питания", "160", "+996 502‒16‒51‒25"),
    )
}