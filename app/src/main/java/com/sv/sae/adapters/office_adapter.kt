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
import com.sv.sae.model.teamModel

class office_adapter ( val offices: ArrayList<teamModel>
): RecyclerView.Adapter<office_adapter.ImageViewHolder>() {
    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.cImage)
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
        val office = offices[position]
        Picasso.get().load(office.imageUrl).into(holder.image)

    }

    override fun getItemCount(): Int {
        return offices.size
    }
}