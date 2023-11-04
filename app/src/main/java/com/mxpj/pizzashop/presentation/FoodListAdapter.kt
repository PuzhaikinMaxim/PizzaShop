package com.mxpj.pizzashop.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.mxpj.pizzashop.databinding.ItemFoodBinding
import com.mxpj.pizzashop.domain.Food

class FoodListAdapter: Adapter<FoodListAdapter.FoodItemViewHolder>() {

    var foodList = listOf<Food>()
        set(value) {
            val diffCallback = FoodItemDiffCallback(field, value)
            val diff = DiffUtil.calculateDiff(diffCallback)
            diff.dispatchUpdatesTo(this)
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodItemViewHolder {
        val binding = ItemFoodBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return FoodItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodItemViewHolder, position: Int) {
        val item = foodList[position]
        with(holder.binding){
            tvFoodName.text = item.name
            tvFoodDescription.text = item.description
            tvPrice.text = item.price
        }
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    class FoodItemViewHolder(val binding: ItemFoodBinding): ViewHolder(binding.root)
}