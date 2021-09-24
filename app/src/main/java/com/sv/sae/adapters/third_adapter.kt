package com.sv.sae.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.sv.sae.R
import com.sv.sae.model.teamModel

class third_adapter ( val thirds: ArrayList<teamModel>
): RecyclerView.Adapter<third_adapter.ImageViewHolder>() {
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
        val third = thirds[position]
        Picasso.get().load(third.imageUrl).into(holder.image)

    }

    override fun getItemCount(): Int {
        return thirds.size
    }
}