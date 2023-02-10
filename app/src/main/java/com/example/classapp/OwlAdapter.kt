package com.example.classapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.classapp.ui.OwlDetailFragment

class OwlAdapter(private val owls: List<Owl>) : RecyclerView.Adapter<OwlAdapter.OwlViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OwlViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.owl_card_view, parent, false)
        return OwlViewHolder(view) {position ->
            val owl = owls[position]

            val bundle = bundleOf(
                "name" to owl.name,
                "latin" to owl.latin,
                "wingspan" to owl.wingspan,
                "image" to owl.image,
                "id" to owl.id,
                "habitat" to owl.habitat
            )

            val detailFragment = OwlDetailFragment()
            detailFragment.arguments = bundle

            val activity = view.context as AppCompatActivity

            activity.supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragment_container_view,detailFragment)
                addToBackStack(null)
            }
        }
    }

    override fun getItemCount() = owls.size

    override fun onBindViewHolder(holder: OwlViewHolder, position: Int) {
        val owl = owls[position]
//        holder.owlImage.setImageResource(owl.image)
//        Glide.with(this).load("http://goo.gl/gEgYUd").into(imageView)
        Glide.with(holder.itemView.context).load(owl.image).into(holder.owlImage)
        holder.owlName.text = owl.name
        holder.owlLatinName.text = owl.latin
        holder.owlWingspan.text = owl.wingspan.toString()
        holder.owlHabitat.text = owl.habitat.toString()
    }

    inner class OwlViewHolder(
        itemView: View,
        private val onItemClick: (adapterPosition: Int) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {
        val owlImage: ImageView = itemView.findViewById(R.id.owl_image)
        val owlName: TextView = itemView.findViewById(R.id.owl_name)
        val owlLatinName: TextView = itemView.findViewById(R.id.owl_latin_name)
        val owlWingspan: TextView = itemView.findViewById(R.id.owl_wingspan)
        val owlHabitat: TextView = itemView.findViewById(R.id.owl_habitat)

        init {
            itemView.setOnClickListener() {
                onItemClick(adapterPosition)
            }
        }

    }


}