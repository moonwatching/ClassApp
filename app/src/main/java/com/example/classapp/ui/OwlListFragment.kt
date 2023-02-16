package com.example.classapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.classapp.*

class OwlListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_owl_list, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.owl_recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val owls = mutableListOf<Owl>()

        for (i in 0..12) {
            owls.add(createOwl(i))
        }

        val adapter = OwlAdapter(owls)
        recyclerView.adapter = adapter

        return view
    }


    private fun createOwl(cycle: Int) = Owl(
        name = owlNames[cycle],
        latin = latinNames[cycle],
        wingspan = owlWingspan[cycle],
        image = owlImageURL[cycle],
        id = cycle,
        habitat = owlHabitats[cycle],
        description = owlDescriptions[cycle]
    )


    //Arrays for List Data
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
        "Glaucidium gnoma",
        "Glaucidium californicum",
        "Micrathene whitneyi",
        "Megascops asio",
        "Megascops kennicottii"
    )

    val owlWingspan = listOf(35, 50, 55, 16, 22, 48, 55, 22, 15, 11, 36, 22, 23)

    val owlImageURL = listOf(
        "https://cincinnatizoo.org/system/assets/uploads/2011/02/barn-owl-web.jpg",// Barn Owl
        "https://www.adirondackalmanack.com/wp-content/uploads/2020/02/Male-Snowy-Owl-by-Joe-Kostoss-of-Eye-in-the-Park-540x375.png", //Snowy Owl
        "https://static.wixstatic.com/media/78ab91_e1794736a4654a5dba3940da3c520247~mv2.jpg/v1/fill/w_625,h_656,al_c,q_85,enc_auto/78ab91_e1794736a4654a5dba3940da3c520247~mv2.jpg", //Great Gray Owl
        "https://static.wixstatic.com/media/78ab91_e55452455df64179af5a1245aa543e5b~mv2.jpg/v1/fill/w_640,h_568,al_c,q_85,usm_0.66_1.00_0.01,enc_auto/78ab91_e55452455df64179af5a1245aa543e5b~mv2.jpg", //Northren Saw Whet Owl
        "https://peregrinefund.org/sites/default/files/styles/raptor_banner_600x430/public/2019-11/raptor-er-boreal-owl-perched-ed-mackerrow.jpg?itok=A3ZPB5H7", // Boreal Owl
        "https://cdn.download.ams.birds.cornell.edu/api/v1/asset/297387821/1800", // Spotted Owl
        "https://www.reconnectwithnature.org/getmedia/bbf87a4f-2bb7-48ca-b948-8ebff37dc835/Great-horned-owl-Shutterstock_1.jpg?width=1500&height=1084&ext=.jpg", // Great Horned Owl
        "https://www.allaboutbirds.org/guide/assets/photo/297386451-480px.jpg", //Burrowing Owl
        "https://www.allaboutbirds.org/guide/assets/photo/297378121-480px.jpg", //Pygmy Owl
        "https://www.owling.com/wp-content/uploads/elf-owl3.jpg", //Elf Owl
        "https://cdn.download.ams.birds.cornell.edu/api/v1/asset/297399141/1800", //Short-Eared Owl
        "https://www.allaboutbirds.org/guide/assets/photo/297361511-480px.jpg", //Eastern Screech Owl
        "https://calmzoo.org/wp-content/uploads/2016/09/Western-Screech-Owl-750x500.jpg" //Western Screech Owl
    )

    val owlHabitats = listOf(
        "Widespread",
        "Arctic",
        "Tundra",
        "Temperate",
        "Tundra/Temperate",
        "Temperate",
        "Widespread",
        "Desert and Prairie",
        "Temperate",
        "Desert and Prairie",
        "Grassland",
        "Temperate",
        "Temperate"
    )

    val owlDescriptions = listOf(
        "The barn owl (Tyto alba) is the most widely distributed species of owl in the world and one of the most widespread of all species of birds, being found almost everywhere except for the polar and desert regions, Asia north of the Himalayas, most of Indonesia, and some Pacific Islands. It is also known as the common barn owl, to distinguish it from the other species in its family, Tytonidae, which forms one of the two main lineages of living owls, the other being the typical owls (Strigidae).",
        "The snowy owl (Bubo scandiacus), also known as the polar owl, the white owl and the Arctic owl, is a large, white owl of the true owl family. Snowy owls are native to the Arctic regions of both North America and the Palearctic, breeding mostly on the tundra. It has a number of unique adaptations to its habitat and lifestyle, which are quite distinct from other extant owls. One of the largest species of owl, it is the only owl with mainly white plumage.",
        "The great grey owl (Strix nebulosa) (also great gray owl in American English) is a very large owl, documented as the world's largest species of owl by length. It is distributed across the Northern Hemisphere, and it is the only species in the genus Strix found in both Eastern and Western Hemispheres. ",
        "The northern saw-whet owl (Aegolius acadicus) is a species of small owl in the family Strigidae. The species is native to North America. Saw-whet owls of the genus Aegolius are some of the smallest owl species in North America. They can be found in dense thickets, often at eye level, although they can also be found some 20 ft (6.1 m) up. ",
        "The boreal owl or Tengmalm's owl (Aegolius funereus) is a small owl in the \"true owl\" family Strigidae. It is known as the boreal owl in North America and as Tengmalm's owl in Europe after Swedish naturalist Peter Gustaf Tengmalm or, more rarely, Richardson's owl after Sir John Richardson.",
        "The spotted owl (Strix occidentalis) is a species of true owl. It is a resident species of old-growth forests in western North America, where it nests in tree hollows, old bird of prey nests, or rock crevices. Nests can be between 12 and 60 metres (39 and 197 ft) high and usually contain two eggs (though some contain as many as four).",
        "The great horned owl (Bubo virginianus), also known as the tiger owl (originally derived from early naturalists' description as the \"winged tiger\" or \"tiger of the air\"), or the hoot owl, is a large owl native to the Americas. It is an extremely adaptable bird with a vast range and is the most widely distributed true owl in the Americas.",
        "The burrowing owl (Athene cunicularia), also called the shoco, is a small, long-legged owl found throughout open landscapes of North and South America. Burrowing owls can be found in grasslands, rangelands, agricultural areas, deserts, or any other open, dry area with low vegetation. They nest and roost in burrows, such as those excavated by prairie dogs (Cynomys spp.).",
        "Pygmy owls are members of the genus Glaucidium. They belong to the typical owl family, Strigidae. The genus consists of 29 species distributed worldwide. These are mostly small owls, and some of the species are called \"owlets\". Most pygmy owl species are nocturnal and they mainly hunt large insects and other small prey.",
        "The elf owl (Micrathene whitneyi) is a small grayish-brown owl about the size of a sparrow found in the Southwestern United States, central Mexico, and the Baja California peninsula. It has pale yellow eyes highlighted by thin white \"eyebrows\" and a gray bill with a horn-colored tip. The elf owl frequently inhabits woodpecker holes in saguaro cacti; it also nests in natural tree cavities. It is nocturnal and feeds primarily on insects.",
        "The short-eared owl (Asio flammeus) is a widespread grassland species in the family Strigidae. Owls belonging to genus Asio are known as the eared owls, as they have tufts of feathers resembling mammalian ears. These \"ear\" tufts may or may not be visible. The short-eared owl will display its tufts when in a defensive pose, although its very short tufts are usually not visible.",
        "The eastern screech owl (Megascops asio) or eastern screech-owl, is a small owl that is relatively common in Eastern North America, from Mexico to Canada. This species is native to most wooded environments of its distribution, and more so than any other owl in its range, has adapted well to manmade development, although it frequently avoids detection due to its strictly nocturnal habits.",
        "The western screech owl (Megascops kennicottii) is a small owl native to North and Central America, closely related to the eastern screech owl. The scientific name commemorates the American naturalist Robert Kennicott."
    )

}