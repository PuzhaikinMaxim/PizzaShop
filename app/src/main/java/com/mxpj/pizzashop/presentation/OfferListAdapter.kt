package com.mxpj.pizzashop.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.mxpj.pizzashop.databinding.ItemOfferBinding
import com.mxpj.pizzashop.domain.Offer

class OfferListAdapter: Adapter<OfferListAdapter.OfferItemViewHolder>() {

    var offerList = listOf<Offer>()
        set(value) {
            val diffCallback = OfferListDiffCallback(field, value)
            val diffResult = DiffUtil.calculateDiff(diffCallback)
            diffResult.dispatchUpdatesTo(this)
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferItemViewHolder {
        val binding = ItemOfferBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return OfferItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OfferItemViewHolder, position: Int) {
        val item = offerList[position]
        with(holder.binding){
            ivOffer.setImageResource(item.imageResource)
        }
    }

    override fun getItemCount(): Int {
        return offerList.size
    }

    class OfferItemViewHolder(val binding: ItemOfferBinding): ViewHolder(binding.root)
}