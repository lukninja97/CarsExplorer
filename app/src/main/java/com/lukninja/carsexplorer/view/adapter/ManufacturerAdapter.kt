package com.lukninja.carsexplorer.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lukninja.carsexplorer.databinding.ListItemManufacturerBinding
import com.lukninja.carsexplorer.service.model.Manufacturer


class ManufacturerAdapter(
    private val values: List<Manufacturer>,
    private val clickListListener: (Manufacturer) -> Unit
) : RecyclerView.Adapter<ManufacturerAdapter.ManufacturerViewHolder>() {

    private var manufactures: List<Manufacturer> = listOf()

    class ManufacturerViewHolder(private val binding: ListItemManufacturerBinding):
        RecyclerView.ViewHolder(binding.root) {
            fun bind(manufacturer: Manufacturer, clickListListener: (Manufacturer) -> Unit) {
                binding.tvName.text = manufacturer.manufacturerCommonName ?: manufacturer.manufacturerName
                binding.tvLocalization.text = manufacturer.city
                binding.tvCountry.text = manufacturer.country
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ManufacturerViewHolder {
        val listItemManufacturer =
            ListItemManufacturerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ManufacturerViewHolder(listItemManufacturer)
    }

    override fun onBindViewHolder(holder: ManufacturerViewHolder, position: Int) {
        holder.bind(manufactures[position], clickListListener)
    }

    override fun getItemCount(): Int = manufactures.count()

    fun updateManufactures(list: List<Manufacturer>){
        manufactures = list
        notifyDataSetChanged()
    }

}