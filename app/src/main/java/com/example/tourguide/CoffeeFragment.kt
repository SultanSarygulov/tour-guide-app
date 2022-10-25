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
        binding.recyclerViewCoffee.adapter = LocationRecyclerAdapter(getLocationNames())
        return binding.root
    }

    private fun getLocationNames(): List<String>{
        return this.resources.getStringArray(R.array.location_names).toList()
    }
}