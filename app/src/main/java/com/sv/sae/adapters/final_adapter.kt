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

class final_adapter ( val finals: ArrayList<teamModel>
): RecyclerView.Adapter<final_adapter.ImageViewHolder>() {
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
        val final = finals[position]
        Picasso.get().load(final.imageUrl).into(holder.image)
        holder.image.setOnClickListener{
            val intent= Intent(Intent.ACTION_VIEW, Uri.parse(final.linkedin))
            holder.image.context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return finals.size
    }
}