package com.example.classapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.classapp.*
import com.example.classapp.databinding.FragmentOwlListBinding
import com.example.classapp.ui.adapter.OwlAdapter
import com.example.classapp.viewmodel.OwlViewModel

class OwlListFragment : Fragment() {

    private var _binding: FragmentOwlListBinding? = null
    private val binding get() = _binding!!

    private val owlViewModel: OwlViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOwlListBinding.inflate(inflater, container, false)

        binding.owlRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        val owls = owlViewModel.fillData()

        val adapter = OwlAdapter(owls) { position ->
            requireActivity().supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(
                    R.id.fragment_container_view,
                    OwlDetailFragment.newInstance(owls[position].id)
                )
                addToBackStack(null)
            }
        }
        binding.owlRecyclerView.adapter = adapter

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}