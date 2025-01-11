package com.example.streethub.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.streethub.databinding.CartItemBinding

class CartAdapter(private val cartItems:MutableList<String>, private val cartItemPrice:MutableList<String>, private val cartItemImage:MutableList<Int>) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {
    private val itemQuantities = IntArray(cartItems.size){1}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CartItemBinding.inflate(LayoutInflater.from(parent.context),parent,false) // holding the cart item xml
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return cartItems.size
    }

    inner class CartViewHolder(private val binding: CartItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                val quantity = itemQuantities[position]
                cartFoodName.text=cartItems[position]
                cartFoodPrice.text=cartItemPrice[position]
                cartFoodImage.setImageResource(cartItemImage[position])
                cartFoodQuantity.text=quantity.toString()

                minusButton.setOnClickListener(){
                    decreaseQuantity(position)
                }

                plusButton.setOnClickListener(){
                    increaseQuantity(position)
                }

                deleteButton.setOnClickListener() {
                    val itemPosition = adapterPosition
                    if(itemPosition != RecyclerView.NO_POSITION){
                        deleteItem(itemPosition)
                    }
                }
            }
        }

        private fun decreaseQuantity(position: Int){
            if(itemQuantities[position]>=1){
                itemQuantities[position]--;
                binding.cartFoodQuantity.text=itemQuantities[position].toString()
            }
        }
        private fun increaseQuantity(position: Int){
            if(itemQuantities[position]<20){
                itemQuantities[position]++;
                binding.cartFoodQuantity.text=itemQuantities[position].toString()
            }
        }
        private fun deleteItem(position: Int){
            cartItems.removeAt(position)
            cartItemPrice.removeAt(position)
            cartItemImage.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, cartItems.size)
        }

    }
}