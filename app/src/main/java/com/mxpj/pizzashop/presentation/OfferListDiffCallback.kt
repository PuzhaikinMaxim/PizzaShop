package com.mxpj.pizzashop.presentation

import androidx.recyclerview.widget.DiffUtil
import com.mxpj.pizzashop.domain.Offer

class OfferListDiffCallback(
    private val oldList: List<Offer>,
    private val newList: List<Offer>
): DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}