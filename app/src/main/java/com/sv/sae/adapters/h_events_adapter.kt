package com.sv.sae.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import com.sv.sae.HomeDirections
import com.sv.sae.R
import com.sv.sae.model.cryptechModel
import com.sv.sae.model.eventModel

class h_events_adapter(
    val events: ArrayList<eventModel>
):RecyclerView.Adapter<h_events_adapter.ImageViewHolder>() {
    inner class ImageViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val image:ImageView=itemView.findViewById(R.id.cImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.h_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val event = events[position]
        Picasso.get().load(event.imageUrl).placeholder(R.drawable.loading_31).into(holder.image)
        val action = HomeDirections.actionHome2ToEventsBtmSheet(name = event.name.toString())
        holder.image.setOnClickListener{
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return events.size
    }
}