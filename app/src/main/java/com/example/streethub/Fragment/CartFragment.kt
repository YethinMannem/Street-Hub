package com.example.streethub.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.streethub.CongratsBottomSheet
import com.example.streethub.PayOutActivity
import com.example.streethub.R
import com.example.streethub.adapter.CartAdapter
import com.example.streethub.databinding.FragmentCartBinding

class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentCartBinding.inflate(inflater, container, false)
        val cartFoodName = listOf("Burger", "Sandwich")
        val cartFoodPrice = listOf("$2", "$3")
        val cartFoodImage = listOf(
            R.drawable.menu1,
            R.drawable.menu2
        )
        val adapter = CartAdapter(ArrayList(cartFoodName), ArrayList(cartFoodPrice), ArrayList(cartFoodImage))
        binding.cartRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecyclerView.adapter = adapter

        binding.proceedButton.setOnClickListener{
            val intent = Intent(requireContext(), PayOutActivity::class.java)
            startActivity(intent)
        }


        return binding.root
    }

    companion object {

    }
}