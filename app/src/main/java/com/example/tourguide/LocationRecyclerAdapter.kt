package com.example.tourguide

import android.content.Intent
import android.net.Uri
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.recyclerview_item.view.*

class LocationRecyclerAdapter (private val description: List<List<String>>, private val type: String):
    RecyclerView.Adapter<LocationRecyclerAdapter.MyViewHolder>(){


    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val button: ImageButton = itemView.findViewById(R.id.button)

        val locationPhoto: ImageView = itemView.findViewById(R.id.location_photo)
        val locationName: TextView = itemView.findViewById(R.id.location_name)
        val locationType: TextView = itemView.findViewById(R.id.location_type)
        val locationAddress: TextView = itemView.findViewById(R.id.location_address)
        val locationClosetime: TextView = itemView.findViewById(R.id.location_closetime)


        // Opened up
        val locationInfo2: RelativeLayout = itemView.findViewById(R.id.location_info2)

        val locationTypeSpec: TextView = itemView.findViewById(R.id.location_type_spec)
        val locationCheck: TextView = itemView.findViewById(R.id.location_check)
        val locationPhone: TextView = itemView.findViewById(R.id.location_phone)
        val locationAddress2: TextView = itemView.findViewById(R.id.location_address2)
        val locationClosetime2: TextView = itemView.findViewById(R.id.location_closetime2)

        val recyclerViewItem: RelativeLayout = itemView.findViewById(R.id.recyclerViewItem)
        val divider: View = itemView.findViewById(R.id.divider)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationRecyclerAdapter.MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).
                    inflate(R.layout.recyclerview_item, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: LocationRecyclerAdapter.MyViewHolder, position: Int) {

        val photoPos = 0
        val namePos = 1
        val addressPos = 2
        val closetimePos = 3

        val infoPos = 4
        val checkPos = 5
        val phonePos = 6

        with(holder){
            Glide.with(locationPhoto)
                .load(description[position][photoPos])
                .into(locationPhoto)

            locationName.text = description[position][namePos]
            locationType.text = type
            locationAddress.text = description[position][addressPos]
            locationClosetime.text = description[position][closetimePos]

            locationTypeSpec.text = description[position][infoPos]
            locationCheck.text = "Средний чек ${description[position][checkPos]} с"
            locationPhone.text = description[position][phonePos]
            locationAddress2.text = description[position][addressPos]
            locationClosetime2.text = description[position][closetimePos]

            locationPhone.setOnClickListener {
                val callIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + locationPhone.text))
                locationPhone.context.startActivity(callIntent)
            }

            locationAddress2.setOnClickListener {
                val callIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://2gis.kg/bishkek/search/" + description[position][addressPos]))
                locationAddress2.context.startActivity(callIntent)
            }

            button.setOnClickListener {
                if (button.contentDescription == "down"){
                    button.setImageResource(R.drawable.arrow_up)
                    locationName.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35.toFloat())
                    locationInfo2.isVisible = true
                    button.contentDescription = "up"
                }
                else if (button.contentDescription == "up") {
                    button.setImageResource(R.drawable.arrow_down)
                    locationName.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24.toFloat())
                    locationInfo2.setVisibility(View.GONE)
                    button.contentDescription = "down"
                }
            }
        }
    }

    override fun getItemCount() = description.size

}