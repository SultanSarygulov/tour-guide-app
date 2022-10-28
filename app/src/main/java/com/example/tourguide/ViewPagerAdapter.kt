package com.example.tourguide

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragment: FragmentActivity): FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 1

    override fun createFragment(position: Int): Fragment {
        return FragmentShawarma()
        //return when(position){
        //    0 -> FragmentShawarma()
        //    1 -> FragmentPizza()
        //    2 -> FragmentCinema()
        //    else -> FragmentCoffee()
        //}
    }
}