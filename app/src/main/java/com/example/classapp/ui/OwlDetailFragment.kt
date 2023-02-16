package com.example.classapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.classapp.R

class OwlDetailFragment : Fragment() {
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_owl_detail, container, false)

        if (arguments != null) {
            val name = requireArguments().getString("name")
            val latin = requireArguments().getString("latin")
            val wingspan = requireArguments().getInt("wingspan")
            val id = requireArguments().getInt("id")
            val image = requireArguments().getString("image")
            val habitat = requireArguments().getString("habitat")
            val description = requireArguments().getString("description")

            view.findViewById<TextView>(R.id.detail_view_owl_name).text = name
            view.findViewById<TextView>(R.id.detail_view_owl_latin).text = latin
            view.findViewById<TextView>(R.id.detail_view_owl_wingspan).text =
                ("Wingspan: $wingspan inches")
            view.findViewById<TextView>(R.id.detail_view_owl_id).text = "ID: $id"
            Glide.with(this).load(image).into(view.findViewById(R.id.detail_view_owl_image))
            view.findViewById<TextView>(R.id.detail_view_owl_description).text = description
            view.findViewById<TextView>(R.id.detail_view_owl_habitat).text = ("Habitat: $habitat")

        }


        return view
    }
}