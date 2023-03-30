package com.example.classapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.classapp.databinding.FragmentOwlDetailBinding
import com.example.classapp.viewmodel.OwlViewModel

class OwlDetailFragment : Fragment() {
    private val owlViewModel: OwlViewModel by activityViewModels()

    private var _binding: FragmentOwlDetailBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentOwlDetailBinding.inflate(inflater, container, false)

        if (arguments != null) {
            val owl = owlViewModel.fetchById(requireArguments().getInt(BUNDLE_ID))

            Glide.with(requireContext()).load(owl.image).into(binding.detailViewOwlImage)
            binding.detailViewOwlId.text = owl.id.toString()
            binding.detailViewOwlName.text = owl.name
            binding.detailViewOwlDescription.text = owl.description
            binding.detailViewOwlLatin.text = owl.latin
            binding.detailViewOwlHabitat.text = owl.habitat
            binding.detailViewOwlWingspan.text = owl.wingspan.toString()

        }

        return binding.root
    }

    companion object {
        private const val BUNDLE_ID = "id"
        fun newInstance(id: Int) = OwlDetailFragment().apply {
            arguments = bundleOf(BUNDLE_ID to id)
        }
    }
}