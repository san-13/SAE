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
import com.sv.sae.model.latestModel

class latest_adapter(
    val latests: ArrayList<latestModel>
): RecyclerView.Adapter<latest_adapter.ImageViewHolder>() {
    inner class ImageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val image: ImageView =itemView.findViewById(R.id.lImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.latest_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val latest = latests[position]
        Picasso.get().load(latest.imageUrl).into(holder.image)
        holder.image.setOnClickListener{
            val action= HomeDirections.actionHome2ToEventsBtmSheet(name = latest.name.toString())
            holder.itemView.findNavController().navigate(action)

        }
    }

    override fun getItemCount(): Int {
        return latests.size
    }
}