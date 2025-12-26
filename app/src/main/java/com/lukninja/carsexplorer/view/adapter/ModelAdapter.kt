package com.lukninja.carsexplorer.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lukninja.carsexplorer.databinding.ListItemModelBinding
import com.lukninja.carsexplorer.service.model.dto.ModelDto
import com.lukninja.carsexplorer.service.model.entity.ModelEntity


class ModelAdapter() : RecyclerView.Adapter<ModelAdapter.ModelViewHolder>() {

    private var models: List<ModelEntity> = listOf()

    class ModelViewHolder(private val binding: ListItemModelBinding):
        RecyclerView.ViewHolder(binding.root) {
            fun bind(model: ModelEntity) {
                binding.tvModel.text = model.name
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
        val listItemModelBinding =
            ListItemModelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ModelViewHolder(listItemModelBinding)
    }

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {
        holder.bind(models[position])
    }

    override fun getItemCount(): Int = models.count()

    fun updateModels(list: List<ModelEntity>){
        models = list
        notifyDataSetChanged()
    }

}