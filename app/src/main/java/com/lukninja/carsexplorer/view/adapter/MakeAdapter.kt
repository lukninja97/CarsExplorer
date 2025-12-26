package com.lukninja.carsexplorer.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lukninja.carsexplorer.databinding.ListItemMakeBinding
import com.lukninja.carsexplorer.service.model.entity.MakeEntity


class MakeAdapter(
    private val clickListListener: (MakeEntity) -> Unit
) : RecyclerView.Adapter<MakeAdapter.MakeViewHolder>() {

    private var makes: List<MakeEntity> = listOf()

    class MakeViewHolder(private val binding: ListItemMakeBinding):
        RecyclerView.ViewHolder(binding.root) {
            fun bind(make: MakeEntity, clickListListener: (MakeEntity) -> Unit) {
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

    fun updateMakes(list: List<MakeEntity>){
        makes = list
        notifyDataSetChanged()
    }

}