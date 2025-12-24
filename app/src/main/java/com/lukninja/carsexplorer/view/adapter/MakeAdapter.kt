package com.lukninja.carsexplorer.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lukninja.carsexplorer.databinding.ListItemMakeBinding
import com.lukninja.carsexplorer.service.model.Make


class MakeAdapter(
    private val values: List<Make>,
    private val clickListListener: (Make) -> Unit
) : RecyclerView.Adapter<MakeAdapter.MakeViewHolder>() {

    private var makes: List<Make> = listOf()

    class MakeViewHolder(private val binding: ListItemMakeBinding):
        RecyclerView.ViewHolder(binding.root) {
            fun bind(make: Make, clickListListener: (Make) -> Unit) {
                binding.tvMake.text = make.name

                binding.root.setOnClickListener {
                    clickListListener(make)
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MakeViewHolder {
        val listItemMakeBinding =
            ListItemMakeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MakeViewHolder(listItemMakeBinding)
    }

    override fun onBindViewHolder(holder: MakeViewHolder, position: Int) {
        holder.bind(makes[position], clickListListener)
    }

    override fun getItemCount(): Int = makes.count()

    fun updateMakes(list: List<Make>){
        makes = list
        notifyDataSetChanged()
    }

}