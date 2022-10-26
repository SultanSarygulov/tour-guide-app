package com.example.tourguide

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tourguide.databinding.FragmentPizzaBinding

class FragmentPizza : Fragment() {

    private val photo = "https://pbs.twimg.com/ext_tw_video_thumb/1533643804389085185/pu/img/aZFC-czlC1ZLG-hr.jpg"

    private lateinit var binding: FragmentPizzaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPizzaBinding.inflate(inflater, container, false)

        binding.recyclerViewPizza.layoutManager = LinearLayoutManager(this@FragmentPizza.context)
        binding.recyclerViewPizza.adapter = LocationRecyclerAdapter(pizzaLocations, "Пиццерия", photo)
        return binding.root
    }

    private val pizzaLocations: List<List<String>> = listOf(
        listOf("Capito", "Турусбекова, 100", "Открыто до 00:00"),
        listOf("Papa Johns", "Тоголок Молдо, 3а", "Открыто до 00:00"),
        listOf("Империя Пиццы", "Киевская, 148", "Открыто до 04:00"),
        listOf("Dolche Vita", "Исанова, 80", "Открыто до 00:00"),
        listOf("Dodo Pizza", "Шевченко, 80", "Открыто до 01:00"),
        listOf("NY Pizza", "Киевская, 89", "Открыто до 00:00"),
    )
}