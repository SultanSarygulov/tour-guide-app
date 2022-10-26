package com.example.tourguide

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tourguide.databinding.FragmentCoffeeBinding

class FragmentCoffee : Fragment() {

    private lateinit var binding: FragmentCoffeeBinding

    private val photo = "https://pbs.twimg.com/ext_tw_video_thumb/1533643804389085185/pu/img/aZFC-czlC1ZLG-hr.jpg"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCoffeeBinding.inflate(inflater, container, false)

        binding.recyclerViewCoffee.layoutManager = LinearLayoutManager(this@FragmentCoffee.context)
        binding.recyclerViewCoffee.adapter = LocationRecyclerAdapter(coffeeLocations, "Кофейня", photo)
        return binding.root
    }

    private val coffeeLocations: List<List<String>> = listOf(
        listOf("The Kata", "Токомбаева, 23/9", "Открыто до 22:00"),
        listOf("CocoGin", "Манаса, 9", "Открыто до 02:00"),
        listOf("Traveler's Coffee", "Токтогула, 107", "Открыто до 00:00"),
        listOf("Kiwi", "Кок-Жар, 7/1", "Открыто до 00:00"),
        listOf("Monkey Coffee", "Токтогула, 165", "Открыто до 23:00"),
        listOf("Aldo Coffee", "Горького, 19", "Открыто до 04:00"),
    )
}