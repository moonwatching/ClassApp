package com.example.classapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.classapp.R

class OwlDetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_owl_detail, container, false)

        if (arguments != null) {
            val name = requireArguments().getString("name")
            val latin = requireArguments().getString("latin")
            val wingspan = requireArguments().getString("wingspan")
            val id = requireArguments().getString("id")
            val image = requireArguments().getString("image")
            val habitat = requireArguments().getString("habitat")
        }

        view.findViewById<TextView>(R.id.owl_habitat_text)
        return view
    }
}