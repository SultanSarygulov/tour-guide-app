package com.example.tourguide

interface Listener {

    fun call(number: String)

    fun openMap(address: String)
}