package com.example.classapp.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.classapp.model.Bird
import com.example.classapp.databinding.BirdCardViewBinding

class BirdAdapter(
    private val onItemClick: (bird: Bird, adapterPosition: Int) -> Unit
) : RecyclerView.Adapter<BirdAdapter.BirdViewHolder>() {

    init {
        setHasStableIds(true)
    }

    private val birdSet = mutableListOf<Bird>()

    @SuppressLint("NotifyDataSetChanged")
    fun refreshData(birds: List<Bird>) {
        birdSet.clear()
        birdSet.addAll(birds)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BirdViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = BirdCardViewBinding.inflate(layoutInflater, parent, false)
        return BirdViewHolder(binding) { position ->
            onItemClick(birdSet[position], position)
        }
    }

    override fun getItemCount() = birdSet.size

    override fun getItemId(position: Int) = position.toLong()

    @SuppressLint("SetTextI18n") //error handling localization which we don't really care about in a personal app
    override fun onBindViewHolder(holder: BirdViewHolder, position: Int) {
        val bird = birdSet[position]
        holder.bind(bird)
    }

    inner class BirdViewHolder(
        private val binding: BirdCardViewBinding,
        private val onItemClick: (adapterPosition: Int) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onItemClick(adapterPosition)
            }
        }

        fun bind(bird: Bird) {
            binding.birdName.text = bird.comName
            binding.birdDate.text = bird.obsDt
            binding.birdLatinName.text = bird.sciName
            binding.birdLocationName.text = bird.locName
        }
    }
}
