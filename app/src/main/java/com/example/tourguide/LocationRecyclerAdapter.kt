package com.example.tourguide

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tourguide.databinding.RecyclerviewItemBinding

class LocationRecyclerAdapter (private val names: List<List<String>>):
    RecyclerView.Adapter<LocationRecyclerAdapter.MyViewHolder>(){


    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val locationPhoto: ImageView = itemView.findViewById(R.id.location_photo)
        val locationName: TextView = itemView.findViewById(R.id.location_name)
        val locationType: TextView = itemView.findViewById(R.id.location_type)
        val locationAddress: TextView = itemView.findViewById(R.id.location_address)
        val locationClosetime: TextView = itemView.findViewById(R.id.location_closetime)
        // Opened up
        //val locationTypeSpec: TextView = itemView.findViewById(R.id.location_type_spec)
        //val locationCheck: TextView = itemView.findViewById(R.id.location_check)
        //val locationPhone: TextView = itemView.findViewById(R.id.location_phone)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationRecyclerAdapter.MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).
                    inflate(R.layout.recyclerview_item, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: LocationRecyclerAdapter.MyViewHolder, position: Int) {

        holder.locationName.text = names[position][0]
        holder.locationType.text = "Шаурмячная"
        holder.locationAddress.text = names[position][1]
        holder.locationClosetime.text = names[position][2]
        //holder.locationTypeSpec.text = "Турецкая шаурмячная"
        //holder.locationCheck.text = "Средний чек 800 с"
        //holder.locationPhone.text = "+996 505 505 505"

    }

    override fun getItemCount() = names.size

}