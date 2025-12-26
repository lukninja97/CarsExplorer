package com.lukninja.carsexplorer.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.lukninja.carsexplorer.R
import com.lukninja.carsexplorer.databinding.FragmentMakesListBinding
import com.lukninja.carsexplorer.service.model.entity.MakeEntity
import com.lukninja.carsexplorer.service.util.ApiResult
import com.lukninja.carsexplorer.view.adapter.MakeAdapter
import com.lukninja.carsexplorer.viewmodel.MakeViewModel
import kotlin.getValue


class MakesListFragment : Fragment() {

    private var _binding: FragmentMakesListBinding? = null
    private val binding: FragmentMakesListBinding get() = _binding!!

    private val viewModel: MakeViewModel by viewModels()
    private lateinit var adapter: MakeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMakesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = MakeAdapter { make ->
            val makeBundle = Bundle()
            makeBundle.putString("make", make.name)
            arguments = makeBundle
            findNavController().navigate(R.id.manufacturesListFragment, arguments)
        }

        setupRecycler()
        observers()
        refreshList()

        binding.swipeRefresh.setOnRefreshListener {
            refreshList()
        }
    }

    private fun refreshList() {
        showLoading()
        viewModel.load()
    }

    private fun observers() {
        viewModel.makeList.observe(viewLifecycleOwner) {
            when(it) {
                is ApiResult.Loading -> showLoading()

                is ApiResult.Success -> showMakes(it.data)

                is ApiResult.Error -> showError(it.message, it.throwable)
            }
        }
    }

    private fun setupRecycler() {
        val recycler = binding.rvMakes
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
        binding.rvMakes.visibility = View.INVISIBLE
        binding.msgEmpty.visibility = View.GONE
    }

    private fun hideLoading() {
        binding.rvMakes.visibility = View.VISIBLE
        binding.progress.visibility = View.INVISIBLE
        binding.msgEmpty.visibility = View.GONE
        binding.swipeRefresh.isRefreshing = false
    }

    private fun showMakes(makes: List<MakeEntity>) {
        adapter.updateMakes(makes)
        hideLoading()
    }

    private fun showError(msg: String, e: Throwable?) {
        Log.e("erro", msg, e)
        binding.msgEmpty.visibility = View.VISIBLE
        binding.progress.visibility = View.INVISIBLE
        binding.swipeRefresh.isRefreshing = false
        Toast.makeText(requireContext(), "Sem Marcas, tente novamente com uma conexão de internet", Toast.LENGTH_SHORT).show()
    }

}