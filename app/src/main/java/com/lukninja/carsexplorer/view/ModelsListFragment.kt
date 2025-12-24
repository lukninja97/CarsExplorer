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
import com.lukninja.carsexplorer.databinding.FragmentModelsListBinding
import com.lukninja.carsexplorer.service.model.Make
import com.lukninja.carsexplorer.service.model.Model
import com.lukninja.carsexplorer.service.model.Models
import com.lukninja.carsexplorer.service.util.ApiResult
import com.lukninja.carsexplorer.view.adapter.ModelAdapter
import com.lukninja.carsexplorer.viewmodel.ModelViewModel
import kotlin.getValue


class ModelsListFragment : Fragment() {

    private var _binding: FragmentModelsListBinding? = null
    private val binding: FragmentModelsListBinding get() = _binding!!

    private val viewModel: ModelViewModel by viewModels()
    private lateinit var adapter: ModelAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentModelsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var make = ""

        arguments?.let {
            make = it.getString("make") ?: ""
            viewModel.loadModels(make)
        }

        adapter = ModelAdapter(mutableListOf()) {
            //TODO Click item list
        }

        setupRecycler()
        observers()
        refreshList(make)

        binding.swipeRefresh.setOnRefreshListener {
            refreshList(make)
        }
    }

    private fun refreshList(make: String) {
        binding.rvModels.visibility = View.INVISIBLE
        binding.progress.visibility = View.VISIBLE
        viewModel.loadModels(make)
    }

    private fun observers() {
        viewModel.modelList.observe(viewLifecycleOwner) {
            when(it) {
                is ApiResult.Loading -> showLoading()

                is ApiResult.Success -> showModels(it.data)

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

    private fun showModels(models: Models) {
        binding.tvMake.text = models.searchCriteria
        binding.tvQuantity.text = "${models.count} modelos"
        adapter.updateModels(models.models ?: listOf())
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