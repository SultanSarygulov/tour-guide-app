package com.example.tourguide

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tourguide.databinding.FragmentCinemaBinding
import com.example.tourguide.databinding.FragmentShawarmaBinding

class FragmentCinema : Fragment() {

    private val photo = "https://pbs.twimg.com/ext_tw_video_thumb/1533643804389085185/pu/img/aZFC-czlC1ZLG-hr.jpg"

    private lateinit var binding: FragmentCinemaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCinemaBinding.inflate(inflater, container, false)

        binding.recyclerView.layoutManager =
            LinearLayoutManager(this.context)
        binding.recyclerView.adapter =
            LocationRecyclerAdapter(cinemaLocations, "Кинотеатр", photo)
        return binding.root
    }

    private val cinemaLocations: List<List<String>> = listOf(
        listOf("Ала-Тоо", "Проспект Чуй, 187", "Открыто до 00:00"),
        listOf("Манас", "Чынгыза Айтматова, 47а", "Открыто до 00:00"),
        listOf("Россия", "Проспект Чуй, 213", "Открыто до 00:00"),
        listOf("Sky Cinema", "Виноградная, 1/14а", "Открыто до 00:00"),
        listOf("Октябрь", "Проспект Чуй, 184", "Открыто до 00:00"),
        listOf("TSUM Cinema", "Шопокова, 91", "Открыто до 00:00"),
        listOf("Broadway", "Чынгыза Айтматова, 3", "Открыто до 00:00"),
    )
}