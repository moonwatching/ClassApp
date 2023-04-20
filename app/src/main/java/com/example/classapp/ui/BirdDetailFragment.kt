package com.example.classapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.classapp.databinding.FragmentBirdDetailBinding
import com.example.classapp.viewmodel.BirdViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.random.Random

@AndroidEntryPoint
class BirdDetailFragment : Fragment() {
    private var _binding: FragmentBirdDetailBinding? = null
    private val binding get() = _binding!!

    private val birdViewModel: BirdViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentBirdDetailBinding.inflate(inflater, container, false)

        if (arguments != null) {
            val bird = birdViewModel.getBirdById(requireArguments().getInt(BUNDLE_ID))

            //loads a random image - API did not come with an image so to make the app prettier I used this
            Glide.with(requireContext())
                .load(birdImageURL[Random.nextInt(0, 12)])
                .into(binding.detailViewBirdImage)
            binding.detailViewBirdCount.text = bird.howMany.toString()
            binding.detailViewBirdId.text = bird.subId
            binding.detailViewBirdLat.text = bird.lat.toString()
            binding.detailViewBirdLong.text = bird.lng.toString()
            binding.detailViewBirdLatin.text = bird.sciName
            binding.detailViewBirdLocation.text = bird.locName
            binding.detailViewBirdName.text = bird.comName
        }
        return binding.root
    }

    companion object {
        private const val BUNDLE_ID = "id"
        fun newInstance(id: Int) = BirdDetailFragment().apply {
            arguments = bundleOf(BUNDLE_ID to id)
        }
    }

    private val birdImageURL = listOf(
        "https://cincinnatizoo.org/system/assets/uploads/2011/02/barn-bird-web.jpg",// Barn Bird
        "https://www.adirondackalmanack.com/wp-content/uploads/2020/02/Male-Snowy-Bird-by-Joe-Kostoss-of-Eye-in-the-Park-540x375.png", //Snowy Bird
        "https://static.wixstatic.com/media/78ab91_e1794736a4654a5dba3940da3c520247~mv2.jpg/v1/fill/w_625,h_656,al_c,q_85,enc_auto/78ab91_e1794736a4654a5dba3940da3c520247~mv2.jpg", //Great Gray Bird
        "https://static.wixstatic.com/media/78ab91_e55452455df64179af5a1245aa543e5b~mv2.jpg/v1/fill/w_640,h_568,al_c,q_85,usm_0.66_1.00_0.01,enc_auto/78ab91_e55452455df64179af5a1245aa543e5b~mv2.jpg", //Northren Saw Whet Bird
        "https://peregrinefund.org/sites/default/files/styles/raptor_banner_600x430/public/2019-11/raptor-er-boreal-bird-perched-ed-mackerrow.jpg?itok=A3ZPB5H7", // Boreal Bird
        "https://cdn.download.ams.birds.cornell.edu/api/v1/asset/297387821/1800", // Spotted Bird
        "https://www.reconnectwithnature.org/getmedia/bbf87a4f-2bb7-48ca-b948-8ebff37dc835/Great-horned-bird-Shutterstock_1.jpg?width=1500&height=1084&ext=.jpg", // Great Horned Bird
        "https://www.allaboutbirds.org/guide/assets/photo/297386451-480px.jpg", //Burrowing Bird
        "https://www.allaboutbirds.org/guide/assets/photo/297378121-480px.jpg", //Pygmy Bird
        "https://www.birding.com/wp-content/uploads/elf-bird3.jpg", //Elf Bird
        "https://cdn.download.ams.birds.cornell.edu/api/v1/asset/297399141/1800", //Short-Eared Bird
        "https://www.allaboutbirds.org/guide/assets/photo/297361511-480px.jpg", //Eastern Screech Bird
        "https://calmzoo.org/wp-content/uploads/2016/09/Western-Screech-Bird-750x500.jpg" //Western Screech Bird
    )
}

