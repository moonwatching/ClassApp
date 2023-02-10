package com.example.classapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.classapp.*
import kotlin.random.Random

class OwlListFragment : Fragment() {

    val owlNames = listOf("Barn Owl", "Snowy Owl", "Great Gray Owl", "Northern Saw Whet Owl", "Boreal Owl", "Spotted Owl", "Great Horned Owl",
        "Burrowing Owl", "Pygmy Owl", "Elf Owl", "Short-eared Owl", "Eastern Screech Owl", "Western Screech Owl")
    val latinnames = listOf("Tyto Alba", "Bubo Scandiacus", "Strix nebulosa", "Aegolius acadicus", "Aegolius funereus", "Strix occidentalis", "Bubo virginianus",
        "Athene cunicularia", "Glaucidium californicum", "Micrathene whitneyi", "Megascops asio", "Megascops kennicottii")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_owl_list, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.owl_recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val owls = mutableListOf<Owl>()

        for (i in 0..30) {
            owls.add(createOwl())
        }

        val adapter = OwlAdapter(owls)
        recyclerView.adapter = adapter

        return view
    }


    private fun createOwl() = Owl(
        name = owlNames.random(),
        latin = latinnames.random(),
        wingspan = Random.nextInt(10,30),
        image = "https://hawaiibirdingtrails.hawaii.gov/wp-content/uploads/Barn-Owl_Sherman-Wing-1024x1024.jpg",
        id = 0,
        habitat = "Temperate"
    )
}