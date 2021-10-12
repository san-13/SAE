package com.sv.sae.adapters

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.sv.sae.R
import com.sv.sae.model.teamModel

class second_adapter ( val seconds: ArrayList<teamModel>
): RecyclerView.Adapter<second_adapter.ImageViewHolder>() {
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
        val second = seconds[position]
        Picasso.get().load(second.imageUrl).into(holder.image)
        holder.image.setOnClickListener{
            val intent= Intent(Intent.ACTION_VIEW, Uri.parse(second.linkedin))
            holder.image.context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return seconds.size
    }
}