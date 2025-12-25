package com.lukninja.carsexplorer.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.lukninja.carsexplorer.R
import com.lukninja.carsexplorer.databinding.FragmentManufacturesListBinding
import com.lukninja.carsexplorer.service.model.Manufactures
import com.lukninja.carsexplorer.service.util.ApiResult
import com.lukninja.carsexplorer.view.adapter.ManufacturerAdapter
import com.lukninja.carsexplorer.view.adapter.ModelAdapter
import com.lukninja.carsexplorer.viewmodel.ManufacturerViewModel
import kotlin.getValue


class ManufacturesListFragment : Fragment() {

    private var _binding: FragmentManufacturesListBinding? = null
    private val binding: FragmentManufacturesListBinding get() = _binding!!

    private val viewModel: ManufacturerViewModel by viewModels()
    private lateinit var adapter: ManufacturerAdapter

    private lateinit var make: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentManufacturesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            make = it.getString("make") ?: ""
            viewModel.loadManufactures(make)
        }

        adapter = ManufacturerAdapter(mutableListOf()) { manufacturer ->
            Log.e("manufacturer", manufacturer.toString())
            val makeBundle = Bundle()
            makeBundle.putInt("manufacturerId", manufacturer.manufacturerId ?: 0)
            makeBundle.putString("make", make)
            arguments = makeBundle
            findNavController().navigate(R.id.manufacturerFragment, arguments)
        }

        setupRecycler()
        observers()
        refreshList()

        binding.swipeRefresh.setOnRefreshListener {
            refreshList()
        }
    }

    private fun refreshList() {
        binding.rvModels.visibility = View.INVISIBLE
        binding.progress.visibility = View.VISIBLE
        viewModel.loadManufactures(make)
    }

    private fun observers() {
        viewModel.manufacturerList.observe(viewLifecycleOwner) {
            when(it) {
                is ApiResult.Loading -> showLoading()

                is ApiResult.Success -> showManufactures(it.data)

                is ApiResult.Error -> showError(it.message)
            }
        }
    }

    private fun setupRecycler() {
        val recycler = binding.rvModels
        recycler.layoutManager = LinearLayoutManager(requireContext())

        val divider = DividerItemDecoration(
            recycler.context,
            DividerItemDecoration.VERTICAL
        )
        recycler.addItemDecoration(divider)

        recycler.adapter = adapter
    }

    private fun showLoading() {
        binding.progress.visibility = View.VISIBLE
        binding.rvModels.visibility = View.INVISIBLE
    }

    private fun showManufactures(manufactures: Manufactures) {
        binding.tvMake.text = make
        binding.tvQuantity.text = "${manufactures.count} fabricantes"
        adapter.updateManufactures(manufactures.manufactures ?: listOf())
        binding.rvModels.visibility = View.VISIBLE
        binding.progress.visibility = View.INVISIBLE
        binding.swipeRefresh.isRefreshing = false
//        binding.imgError.visibility = View.GONE
//        binding.tvError.visibility = View.GONE
    }

    private fun showError(msg: String) {
        Log.e("erro", msg)
    }

}