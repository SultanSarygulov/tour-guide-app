package com.example.tourguide

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tourguide.databinding.FragmentCoffeeBinding
import com.example.tourguide.databinding.FragmentShawarmaBinding

class CoffeeFragment : Fragment() {

    private lateinit var binding: FragmentCoffeeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCoffeeBinding.inflate(inflater, container, false)

        binding.recyclerViewCoffee.layoutManager = LinearLayoutManager(this@CoffeeFragment.context)
        binding.recyclerViewCoffee.adapter = LocationRecyclerAdapter(coffeeLocations)
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