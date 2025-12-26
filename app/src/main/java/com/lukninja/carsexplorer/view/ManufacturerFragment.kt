package com.lukninja.carsexplorer.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.lukninja.carsexplorer.databinding.FragmentManufacturerBinding
import com.lukninja.carsexplorer.service.model.dto.ModelsDto
import com.lukninja.carsexplorer.service.model.entity.ManufacturerEntity
import com.lukninja.carsexplorer.service.model.entity.ModelEntity
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
            viewModel.getManufacturer(manufacturerId)
        }

        adapterModels = ModelAdapter()

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

                is ApiResult.Error -> showError(it.message, it.throwable)
            }
        }

        viewModelModels.modelList.observe(viewLifecycleOwner) {
            when(it) {
                is ApiResult.Loading -> showLoading()

                is ApiResult.Success -> showModels(it.data)

                is ApiResult.Error -> showError(it.message, it.throwable)
            }
        }
    }

    private fun showLoading() {
        binding.progress.visibility = View.VISIBLE
//        binding.tvManufacturer.visibility = View.INVISIBLE
//        binding.cardManufacturer.visibility = View.INVISIBLE
//        binding.tvModels.visibility = View.INVISIBLE
//        binding.cardModels.visibility = View.INVISIBLE
    }

    private fun hideLoading() {
        binding.progress.visibility = View.INVISIBLE
//        binding.tvManufacturer.visibility = View.VISIBLE
//        binding.cardManufacturer.visibility = View.VISIBLE
//        binding.tvModels.visibility = View.VISIBLE
        binding.cardModels.visibility = View.VISIBLE
        binding.msgEmpty.visibility = View.GONE
    }

    private fun showManufacturer(manufacturer: ManufacturerEntity) {
        binding.tvMake.text = make
        binding.tvManufacturer.text = manufacturer.manufacturerCommonName
        binding.tvName.text = manufacturer.manufacturerName
        binding.tvEmail.text = manufacturer.contactEmail
        binding.tvPhone.text = manufacturer.contactPhone
        binding.tvAdress.text = manufacturer.address
        binding.tvPrincipal.text = manufacturer.principalFirstName
        binding.tvPrincipalPosition.text = manufacturer.principalPosition
        binding.tvSubmited.text = manufacturer.submittedName
        binding.tvSubmitedPosition.text = manufacturer.submittedPosition

        viewModelModels.loadModels(make)
    }

    private fun showModels(models: List<ModelEntity>) {
        adapterModels.updateModels(models)

        hideLoading()
    }

    private fun showError(msg: String, e: Throwable?) {
        Log.e("erro", msg, e)
        binding.progress.visibility = View.INVISIBLE
        binding.msgEmpty.visibility = View.VISIBLE
        Toast.makeText(requireContext(), "tente novamente com uma conexão de internet", Toast.LENGTH_SHORT).show()
    }

}