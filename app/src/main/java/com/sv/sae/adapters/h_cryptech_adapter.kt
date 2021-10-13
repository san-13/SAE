package com.sv.sae.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.request.target.ImageViewTarget
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.squareup.picasso.Picasso
import com.sv.sae.HomeDirections
import com.sv.sae.R
import com.sv.sae.info_btm_sheet
import com.sv.sae.model.cryptechModel
import kotlinx.coroutines.flow.callbackFlow

class h_cryptech_adapter(
    val cryptechs: ArrayList<cryptechModel>
): RecyclerView.Adapter<h_cryptech_adapter.ImageViewHolder>() {
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
        val cryptech = cryptechs[position]
        Picasso.get().load(cryptech.imageUrl).placeholder(R.drawable.loading_31).into(holder.image)
        holder.image.setOnClickListener{
            val action=HomeDirections.actionHome2ToInfoBtmSheet(name = cryptech.name.toString(),ytlink = cryptech.ytlink.toString())
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return cryptechs.size
    }
}