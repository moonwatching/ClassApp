package com.example.classapp.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.classapp.model.Owl
import com.example.classapp.databinding.OwlCardViewBinding

class OwlAdapter(
    private val owls: List<Owl>,
    private val onItemClick: (adapterPosition: Int) -> Unit
) :
    RecyclerView.Adapter<OwlAdapter.OwlViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OwlViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = OwlCardViewBinding.inflate(layoutInflater, parent, false)

        return OwlViewHolder(binding) { position ->
            onItemClick(position)
        }
    }

    override fun getItemCount() = owls.size

    @SuppressLint("SetTextI18n") //error handling localization which we don't really care about in a personal app
    override fun onBindViewHolder(holder: OwlViewHolder, position: Int) {
        val owl = owls[position]
        holder.bind(owl)
    }

    inner class OwlViewHolder(
        private val binding: OwlCardViewBinding,
        private val onItemClick: (adapterPosition: Int) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onItemClick(adapterPosition)
            }
        }

        fun bind(owl: Owl) {
            Glide
                .with(binding.root)
                .load(owl.image)
                .into(binding.owlImage)

            binding.owlName.text = owl.name
            binding.owlLatinName.text = owl.latin
            binding.owlWingspan.text = owl.wingspan.toString()
            binding.owlHabitat.text = owl.habitat
        }
    }
}
