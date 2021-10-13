package com.sv.sae.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.sv.sae.HomeDirections
import com.sv.sae.R
import com.sv.sae.model.webinarModel

class h_webinar_adapter(
    val webinars: ArrayList<webinarModel>
): RecyclerView.Adapter<h_webinar_adapter.ImageViewHolder>() {
    inner class ImageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val image: ImageView =itemView.findViewById(R.id.cImage)
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
        val webinar = webinars[position]
        Picasso.get().load(webinar.imageUrl).placeholder(R.drawable.loading_31).into(holder.image)
        val action = HomeDirections.actionHome2ToInfoBtmSheet(name = webinar.name.toString(), ytlink = webinar.ytlink.toString())
        holder.image.setOnClickListener{
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return webinars.size
    }
}