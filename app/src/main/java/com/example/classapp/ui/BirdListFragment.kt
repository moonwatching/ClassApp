package com.example.classapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.classapp.*
import com.example.classapp.databinding.FragmentBirdListBinding
import com.example.classapp.ui.adapter.BirdAdapter
import com.example.classapp.viewmodel.BirdViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BirdListFragment : Fragment() {

    private var _binding: FragmentBirdListBinding? = null
    private val binding get() = _binding!!

    private val birdViewModel: BirdViewModel by activityViewModels()
    private val birdAdapter = BirdAdapter { bird, _ ->
        requireActivity().supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(
                R.id.fragment_container_view,
                BirdDetailFragment.newInstance(bird.id),
            )
            addToBackStack(null)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBirdListBinding.inflate(inflater, container, false)
        setupObservers()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.birdRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = birdAdapter
        }
        birdViewModel.fillData()
    }

    private fun setupObservers() {
        lifecycleScope.launch {
            birdViewModel.birds.collect { event ->
                when (event) {
                    is BirdViewModel.BirdEvent.Failure -> {
                        binding.progressBar.isGone = true
                        binding.birdRecyclerView.isGone = true
                        Toast.makeText(
                            requireContext(), "Failed",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    is BirdViewModel.BirdEvent.Loading -> {
                        binding.progressBar.isVisible = true
                        binding.birdRecyclerView.isGone = true
                        Toast.makeText(
                            requireContext(), "Loading",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    is BirdViewModel.BirdEvent.Success -> {
                        birdAdapter.refreshData(event.birds)
                        binding.progressBar.isGone = true
                        binding.birdRecyclerView.isVisible = true
                        Toast.makeText(
                            requireContext(), "Success",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}