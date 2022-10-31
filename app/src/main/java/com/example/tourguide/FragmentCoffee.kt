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
        binding.recyclerViewCoffee.adapter = LocationRecyclerAdapter(coffeeLocations, "Кофейня")
        return binding.root
    }

    private val coffeeLocations: List<List<String>> = listOf(
        listOf("https://i0.photo.2gis.com/images/branch/0/30258560067483226_9529.jpg", "The Kata", "Токомбаева, 23/9", "Открыто до 22:00", "Ресторан", "1500", "+996 558‒39‒93‒48"),
        listOf("https://i5.photo.2gis.com/images/branch/0/30258560067365260_025b.jpg", "CocoGin", "Манаса, 9", "Открыто до 02:00", "Бар", "400", "+996 558‒39‒93‒45"),
        listOf("https://media-cdn.tripadvisor.com/media/photo-s/0d/67/a3/25/traveler-s-coffee.jpg", "Traveler's Coffee", "Токтогула, 107", "Открыто до 00:00",  "Кофейня", "500","+996 770‒03‒35‒92"),
        listOf("https://i9.photo.2gis.com/images/branch/0/30258560069390818_36d3.jpg", "Kiwi", "Кок-Жар, 7/1", "Открыто до 00:00", "Кофейня", "500", "+996 558‒39‒97‒85"),
        listOf("https://sxodim.com/uploads/posts/2022/10/06/optimized/16ca001fddabe6325fe242ef8bc1da82_220x132-q-85.jpg", "Monkey Coffee", "Токтогула, 165", "Открыто до 23:00", "Кофейня", "700", "+996 770‒00‒45‒91"),
        listOf("https://prod-choiceqr-media.s3.eu-central-1.amazonaws.com/prod-eat-aldo-coffee/ZuENQPr-cDEoFQe-xzkuvku.jpeg", "Aldo Coffee", "Горького, 19", "Открыто до 04:00", "Кофейня", "450", "+996 772‒07‒00‒26"),
    )
}