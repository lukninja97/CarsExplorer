package com.lukninja.carsexplorer.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.lukninja.carsexplorer.databinding.FragmentManufacturerBinding
import com.lukninja.carsexplorer.service.model.Manufacturer
import com.lukninja.carsexplorer.service.model.Models
import com.lukninja.carsexplorer.service.util.ApiResult
import com.lukninja.carsexplorer.view.adapter.ModelAdapter
import com.lukninja.carsexplorer.viewmodel.ManufacturerViewModel
import com.lukninja.carsexplorer.viewmodel.ModelViewModel
import kotlin.getValue


class ManufacturerFragment : Fragment() {

    private var _binding: FragmentManufacturerBinding? = null
    private val binding: FragmentManufacturerBinding get() = _binding!!

    private val viewModel: ManufacturerViewModel by viewModels()
    private val viewModelModels: ModelViewModel by viewModels()

    private lateinit var adapterModels: ModelAdapter

    private lateinit var make: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentManufacturerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            make = it.getString("make") ?: ""
            val manufacturerId = it.getInt("manufacturerId")
            viewModel.getManufacturer(make, manufacturerId)
        }

        adapterModels = ModelAdapter(mutableListOf()) {

        }

        setupRecycler()
        observers()
    }

    private fun setupRecycler() {
        val recycler = binding.rvModels
        recycler.layoutManager = LinearLayoutManager(requireContext())

        val divider = DividerItemDecoration(
            recycler.context,
            DividerItemDecoration.VERTICAL
        )
        recycler.addItemDecoration(divider)

        recycler.adapter = adapterModels
    }

    private fun observers() {
        viewModel.manufacturer.observe(viewLifecycleOwner) {
            when(it) {
                is ApiResult.Loading -> showLoading()

                is ApiResult.Success -> showManufacturer(it.data)

                is ApiResult.Error -> showError(it.message)
            }
        }

        viewModelModels.modelList.observe(viewLifecycleOwner) {
            when(it) {
                is ApiResult.Loading -> showLoading()

                is ApiResult.Success -> showModels(it.data)

                is ApiResult.Error -> showError(it.message)
            }
        }
    }

    private fun showLoading() {
        binding.progress.visibility = View.VISIBLE
        binding.cardManufacturer.visibility = View.INVISIBLE
    }

    private fun showManufacturer(manufacturer: Manufacturer) {
        binding.tvMake.text = make
        binding.tvManufacturer.text = manufacturer.manufacturerCommonName ?: "-"
        binding.tvName.text = manufacturer.manufacturerName ?: "-"
        binding.tvEmail.text = manufacturer.contactEmail ?: "-"
        binding.tvPhone.text = manufacturer.contactPhone ?: "-"
        binding.tvAdress.text = manufacturer.address ?: "-"
        binding.tvPrincipal.text = manufacturer.principalFirstName
        binding.tvPrincipalPosition.text = manufacturer.principalPosition

        binding.tvSubmited.text = manufacturer.submittedName
        binding.tvSubmitedPosition.text = manufacturer.submittedPosition

        binding.cardManufacturer.visibility = View.VISIBLE
        binding.progress.visibility = View.INVISIBLE

        viewModelModels.loadModels(make)
    }

    private fun showModels(models: Models) {
        adapterModels.updateModels(models.models ?: listOf())
        binding.rvModels.visibility = View.VISIBLE
        binding.progress.visibility = View.INVISIBLE
        binding.cardManufacturer.visibility = View.VISIBLE
    }

    private fun showError(msg: String) {
        Log.e("erro", msg)
    }

}