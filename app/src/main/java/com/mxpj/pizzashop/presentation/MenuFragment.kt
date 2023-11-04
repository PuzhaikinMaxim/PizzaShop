package com.mxpj.pizzashop.presentation

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProvider
import com.mxpj.pizzashop.R
import com.mxpj.pizzashop.databinding.FragmentMenuBinding
import javax.inject.Inject

class MenuFragment: BaseFragment<FragmentMenuBinding>(FragmentMenuBinding::inflate) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: MenuViewModel

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[MenuViewModel::class.java]
        setupFoodListAdapter()
        setupOfferListAdapter()
        setupSpinner()
    }

    private fun setupFoodListAdapter() {
        val adapter = FoodListAdapter()
        binding.rvFoodList.adapter = adapter
        adapter.foodList = viewModel.foodList
    }

    private fun setupOfferListAdapter() {
        val adapter = OfferListAdapter()
        binding.rvOfferList.adapter = adapter
        adapter.offerList = viewModel.offerList
    }

    private fun setupSpinner() {
        val arrayAdapter = ArrayAdapter.createFromResource(
            requireActivity(),
            R.array.cities,
            R.layout.item_spinner
        )
        binding.spinnerCity.adapter = arrayAdapter
    }
}