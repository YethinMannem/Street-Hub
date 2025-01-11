package com.example.streethub.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.streethub.R
import com.example.streethub.adapter.PopularAdapter
import com.example.streethub.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageList = ArrayList<SlideModel>().apply {
            add(SlideModel(R.drawable.banner1, ScaleTypes.FIT))
            add(SlideModel(R.drawable.banner2, ScaleTypes.FIT))
            add(SlideModel(R.drawable.banner3, ScaleTypes.FIT))
        }

        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imageList, ScaleTypes.FIT)

        // Set the item click listener for the image slider
        imageSlider.setItemClickListener(object : ItemClickListener {
            override fun doubleClick(position: Int) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(position: Int) {
                val itemMessage = "Selected Image $position"
                val itemPosition = imageList[position]
                Toast.makeText(requireContext(), itemMessage, Toast.LENGTH_SHORT).show()
            }
        })

        val popularFoodNames = listOf("Burger", "Sandwich")
        val popularFoodPrices = listOf("$5", "$7")
        val popularFoodImages = listOf(R.drawable.menu1, R.drawable.menu2)

        val adapter = PopularAdapter(popularFoodNames, popularFoodPrices, popularFoodImages)
        binding.popularRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.popularRecyclerView.adapter = adapter
    }

    companion object {

    }
}
