package com.example.classapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OwlAdapter(private val owls: List<Owl>) : RecyclerView.Adapter<OwlAdapter.OwlViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OwlViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.owl_card_view, parent, false)
        return OwlViewHolder(view)
    }

    override fun getItemCount() = owls.size

    override fun onBindViewHolder(holder: OwlViewHolder, position: Int) {
        val owl = owls[position]
        holder.owlImage.setImageResource(owl.image)
        holder.owlName.text = owl.name
        holder.owlLatinName.text = owl.latin
        holder.owlWingspan.text = owl.wingspan.toString()
        holder.owlHabitat.text = owl.habitat.toString()
    }

    class OwlViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val owlImage: ImageView = itemView.findViewById(R.id.owl_image)
        val owlName: TextView = itemView.findViewById(R.id.owl_name)
        val owlLatinName: TextView = itemView.findViewById(R.id.owl_latin_name)
        val owlWingspan: TextView = itemView.findViewById(R.id.owl_wingspan)
        val owlHabitat: TextView = itemView.findViewById(R.id.owl_habitat)
    }


}