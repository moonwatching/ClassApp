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

    val owlNames = listOf(
        "Barn Owl",
        "Snowy Owl",
        "Great Gray Owl",
        "Northern Saw Whet Owl",
        "Boreal Owl",
        "Spotted Owl",
        "Great Horned Owl",
        "Burrowing Owl",
        "Pygmy Owl",
        "Elf Owl",
        "Short-eared Owl",
        "Eastern Screech Owl",
        "Western Screech Owl"
    )
    val latinNames = listOf(
        "Tyto Alba",
        "Bubo Scandiacus",
        "Strix nebulosa",
        "Aegolius acadicus",
        "Aegolius funereus",
        "Strix occidentalis",
        "Bubo virginianus",
        "Athene cunicularia",
        "Glaucidium californicum",
        "Micrathene whitneyi",
        "Megascops asio",
        "Megascops kennicottii"
    )

    val owlImageURL = listOf(
        "https://hawaiibirdingtrails.hawaii.gov/wp-content/uploads/Barn-Owl_Sherman-Wing-1024x1024.jpg",
        "https://gray-wibw-prod.cdn.arcpublishing.com/resizer/y-_VJ4frYLgVa0oR2-ZfGL1RJ1c=/1200x1800/smart/filters:quality(85)/cloudfront-us-east-1.images.arcpublishing.com/gray/K46VCJHHGZLBXKV3QFGDJIRREE.jpg",
        "https://www.adirondackalmanack.com/wp-content/uploads/2020/06/great-gray-owl-annefraser-78674954_113221200144180_3149966217893117952_o.jpg",
        "https://static.wixstatic.com/media/78ab91_e55452455df64179af5a1245aa543e5b~mv2.jpg/v1/fill/w_640,h_568,al_c,q_85,usm_0.66_1.00_0.01,enc_auto/78ab91_e55452455df64179af5a1245aa543e5b~mv2.jpg",
        "https://peregrinefund.org/sites/default/files/styles/raptor_banner_600x430/public/2019-11/raptor-er-boreal-owl-perched-ed-mackerrow.jpg?itok=A3ZPB5H7",
        "https://www.nps.gov/articles/images/SPOW_5-28-08_Female_5_HeatherJensen.JPG?maxwidth=650&autorotate=false",
        "https://images.squarespace-cdn.com/content/v1/55525830e4b0ac0977512301/1594329843052-WR5VAK0OY7F1L3VKRFBA/ghow.jpg",
        "https://www.allaboutbirds.org/guide/assets/photo/297386451-480px.jpg",
        "https://www.allaboutbirds.org/guide/assets/photo/297378121-480px.jpg",
        "https://www.owling.com/wp-content/uploads/elf-owl3.jpg",
        "https://cdn.download.ams.birds.cornell.edu/api/v1/asset/297399141/1800",
        "https://www.allaboutbirds.org/guide/assets/photo/297361511-480px.jpg",
        "https://images.squarespace-cdn.com/content/v1/5a6390338a02c77bf05da4ab/1578431330653-1VT7M55ICRKWTZN9OVLP/Western+Screech+Owl"
    )

    val owlHabitats = listOf(
        "Temperate",
        "Arctic",
        "Tundra",
        "Found Everywhere",
        "Desert"
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_owl_list, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.owl_recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val owls = mutableListOf<Owl>()

        for (i in 0..30) {
            owls.add(createOwl(i))
        }

        val adapter = OwlAdapter(owls)
        recyclerView.adapter = adapter

        return view
    }


    private fun createOwl(cycle: Int) = Owl(
        name = owlNames[cycle],
        latin = latinNames[cycle],
        wingspan = Random.nextInt(10, 30),
        image = owlImageURL[cycle],
        id = cycle,
        habitat = owlHabitats.random()
    )
}