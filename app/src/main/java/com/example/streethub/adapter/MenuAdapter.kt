package com.example.streethub.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.streethub.databinding.MenuItemBinding

class MenuAdapter(private val menuItemName: List<String>, private val menuItemPrice: List<String>, private val menuItemImage: List<Int>):
    RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = MenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
       holder.bind(position)
    }

    override fun getItemCount(): Int = menuItemName.size

    inner class MenuViewHolder(private val binding: MenuItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                menuFoodName.text=menuItemName[position]
                menuFoodPrice.text=menuItemPrice[position]
                menuFoodImage.setImageResource(menuItemImage[position])
            }
        }

    }
}