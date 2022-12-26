package com.example.tourguide

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tourguide.databinding.FragmentShawarmaBinding

class FragmentShawarma : Fragment(), Listener {

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
            LocationRecyclerAdapter(shawarmaLocations, "Шаурмячная", this)
        return binding.root
    }


    private val shawarmaLocations: List<List<String>> = listOf(
        listOf("https://i8.photo.2gis.com/images/branch/0/30258560067203567_6bd3_300x300.jpg","Oasis", "Московская, 78/1", "Открыто до 22:00", "Киоск фастфудной продукции", "250", "+996 774‒44‒55‒99"),
        listOf("https://i5.photo.2gis.com/images/branch/0/30258560075361905_ecff.jpg", "Эки Дос", "Абдрахманова, 176/5", "Круглосуточно", "Кафе быстрого питания", "130", "+996 509‒82‒28‒22"),
        listOf("https://i8.photo.2gis.com/images/branch/0/30258560053568273_10e4.jpg", "Burger na dorojke", "Тунгуч, 36/4", "Круглосуточно", "Киоск фастфудной продукции", "150", "+996 555‒16‒16‒51"),
        listOf("https://i8.photo.2gis.com/images/branch/0/30258560068852043_d030.jpg", "Muslim Food", "Проспект Ленина, 48", "Открыто до 04:00", "Киоск фастфуда", "150", "Отсутствует"),
        listOf("https://i2.photo.2gis.com/images/branch/0/30258560067843319_72d9.jpg", "Al-Israa", "Кольбаева, 68", "Открыто до 00:00", "Киоск фастфудной продукции", "700", "+996 703‒33‒37‒13"),
        listOf("https://i1.photo.2gis.com/images/branch/0/30258560067202581_9b2d.jpg", "Бир 1/2 Эки", "Проспект Чуй, 110", "Круглосуточно", "Кафе быстрого питания", "160", "+996 502‒16‒51‒25"),
    )

    override fun call(number: String) {
        val callIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number"))
        requireActivity().startActivity(callIntent)
    }

    override fun openMap(address: String) {
        val callIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://2gis.kg/bishkek/search/$address"))
        requireActivity().startActivity(callIntent)
    }
}