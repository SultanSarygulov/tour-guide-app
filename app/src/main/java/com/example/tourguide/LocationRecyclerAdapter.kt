package com.example.tourguide

import android.content.Intent
import android.net.Uri
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tourguide.databinding.RecyclerviewItemBinding
import com.example.tourguide.databinding.RecyclerviewItemOpenBinding
import kotlinx.android.synthetic.main.recyclerview_item.view.*

class LocationRecyclerAdapter (private val description: List<List<String>>,
                               private val type: String,
                               private val listener: Listener):
    RecyclerView.Adapter<LocationRecyclerAdapter.MyViewHolder>(){


    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val binding = RecyclerviewItemBinding.bind(itemView)

        fun bind(item: List<String>) = with(binding) {
            val photoPos = 0
            val namePos = 1
            val addressPos = 2
            val closetimePos = 3

            val infoPos = 4
            val checkPos = 5
            val phonePos = 6

            Glide.with(binding.locationPhoto)
                .load(item[photoPos])
                .into(binding.locationPhoto)

            locationName.text = item[namePos]

            locationType.text = type
            locationAddress.text = item[addressPos]
            locationClosetime.text = item[closetimePos]
            
            locationTypeSpec.text = item[infoPos]
            locationCheck.text = "Средний чек ${item[checkPos]} с"
            locationPhone.text = item[phonePos]
            locationAddress2.text = item[addressPos]
            locationClosetime2.text = item[closetimePos]

            binding.locationPhone.setOnClickListener {
                listener.call(binding.locationPhone.text.toString())
            }

            binding.locationAddress2.setOnClickListener {
                listener.openMap(binding.locationAddress2.text.toString())
            }

            button.setOnClickListener {
                if (button.contentDescription == "down"){
                    // Open item
                    button.setImageResource(R.drawable.arrow_up)
                    locationName.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35.toFloat())
                    locationInfo2.isVisible = true
                    button.contentDescription = "up"

                    locationType.isVisible = false
                    locationAddress.isVisible = false

                    val constraintSet = ConstraintSet()
                    constraintSet.clone(recyclerViewItemLayout)
                    constraintSet.connect(R.id.divider, ConstraintSet.TOP, R.id.location_info2,ConstraintSet.BOTTOM,8)
                    constraintSet.applyTo(recyclerViewItemLayout)
                }
                else if (button.contentDescription == "up") {
                    // Close item
                    button.setImageResource(R.drawable.arrow_down)
                    locationName.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24.toFloat())
                    locationInfo2.setVisibility(View.GONE)
                    button.contentDescription = "down"

                    locationType.isVisible = true
                    locationAddress.isVisible = true

                    val constraintSet = ConstraintSet()
                    constraintSet.clone(recyclerViewItemLayout)
                    constraintSet.connect(R.id.divider, ConstraintSet.TOP, R.id.location_info,ConstraintSet.BOTTOM,8)
                    constraintSet.applyTo(recyclerViewItemLayout)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationRecyclerAdapter.MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).
                    inflate(R.layout.recyclerview_item, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: LocationRecyclerAdapter.MyViewHolder, position: Int) {

        holder.bind(description[position])
    }

    override fun getItemCount() = description.size

}