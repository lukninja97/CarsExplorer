package com.lukninja.carsexplorer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lukninja.carsexplorer.service.model.Manufactures
import com.lukninja.carsexplorer.service.model.Models
import com.lukninja.carsexplorer.service.repository.ManufacturerRepository
import com.lukninja.carsexplorer.service.util.ApiResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ManufacturerViewModel : ViewModel() {
    private val repository = ManufacturerRepository()

    private val mManufacturerList = MutableLiveData<ApiResult<Manufactures>>()
    val manufacturerList: LiveData<ApiResult<Manufactures>> = mManufacturerList

    fun loadManufactures(make: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                mManufacturerList.postValue(ApiResult.Loading)
                mManufacturerList.postValue(repository.getManufactures(make))
            } catch (e: Exception){
                mManufacturerList.postValue(ApiResult.Error("Falha ao carregar os dados", e))
            }
        }
    }
}