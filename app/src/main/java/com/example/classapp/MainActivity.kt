package com.example.classapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

val owlNames = listOf("Barn Owl", "Snowy Owl", "Great Gray Owl", "Northern Saw Whet Owl", "Boreal Owl", "Spotted Owl", "Great Horned Owl",
                      "Burrowing Owl", "Pygmy Owl", "Elf Owl", "Short-eared Owl", "Eastern Screech Owl", "Western Screech Owl")
val latinnames = listOf("Tyto Alba", "Bubo Scandiacus", "Strix nebulosa", "Aegolius acadicus", "Aegolius funereus", "Strix occidentalis", "Bubo virginianus",
                        "Athene cunicularia", "Glaucidium californicum", "Micrathene whitneyi", "Megascops asio", "Megascops kennicottii")



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.owl_recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val owls = mutableListOf<Owl>()

        for (i in 0..30) {
            owls.add(createOwl())
        }

        val adapter = OwlAdapter(owls)
        recyclerView.adapter = adapter
    }

        private fun createOwl() = Owl(
            name = owlNames.random(),
            latin = latinnames.random(),
            wingspan = Random.nextInt(10,30),
            image = R.drawable.baseline_draw_24,
            id = 0,
            habitat = "Temperate"
        )
    }