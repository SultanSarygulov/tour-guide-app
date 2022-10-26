package com.example.tourguide

import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.recyclerview_item.view.*

class LocationRecyclerAdapter (private val description: List<List<String>>, private val type: String, private val photo: String):
    RecyclerView.Adapter<LocationRecyclerAdapter.MyViewHolder>(){


    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val button: ImageButton = itemView.findViewById(R.id.button)

        val locationPhoto: ImageView = itemView.findViewById(R.id.location_photo)
        val locationName: TextView = itemView.findViewById(R.id.location_name)
        val locationType: TextView = itemView.findViewById(R.id.location_type)
        val locationAddress: TextView = itemView.findViewById(R.id.location_address)
        val locationClosetime: TextView = itemView.findViewById(R.id.location_closetime)


        // Opened up
//        val locationTypeSpec: TextView = itemView.findViewById(R.id.location_type_spec)
//        val locationCheck: TextView = itemView.findViewById(R.id.location_check)
//        val locationPhone: TextView = itemView.findViewById(R.id.location_phone)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationRecyclerAdapter.MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).
                    inflate(R.layout.recyclerview_item, parent, false)



        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: LocationRecyclerAdapter.MyViewHolder, position: Int) {

        Glide.with(holder.locationPhoto)
            .load(photo)
            .into(holder.locationPhoto)
        holder.locationName.text = description[position][0]
        holder.locationType.text = type
        holder.locationAddress.text = description[position][1]
        holder.locationClosetime.text = description[position][2]
        holder.button.setOnClickListener {
            holder.button.setImageResource(R.drawable.arrow_up)
        }
//        holder.locationTypeSpec.text = "Турецкая шаурмячная"
//        holder.locationCheck.text = "Средний чек 800 с"
//        holder.locationPhone.text = "+996 505 505 505"

    }

    override fun getItemCount() = description.size

}