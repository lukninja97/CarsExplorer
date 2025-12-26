package com.lukninja.carsexplorer.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.lukninja.carsexplorer.service.model.entity.ManufacturerEntity
import com.lukninja.carsexplorer.service.repository.ManufacturerRepository
import com.lukninja.carsexplorer.service.repository.local.DatabaseProvider
import com.lukninja.carsexplorer.service.util.ApiResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ManufacturerViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ManufacturerRepository

    init {
        val db = DatabaseProvider.getDatabase(application.applicationContext)
        repository = ManufacturerRepository(db.ManufacturerDao())
    }

    private val mManufacturerList = MutableLiveData<ApiResult<List<ManufacturerEntity>>>()
    val manufacturerList: LiveData<ApiResult<List<ManufacturerEntity>>> = mManufacturerList

    private val mManufacturer = MutableLiveData<ApiResult<ManufacturerEntity>>()
    val manufacturer: LiveData<ApiResult<ManufacturerEntity>> = mManufacturer

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

    fun getManufacturer(manufacturerId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                mManufacturer.postValue(ApiResult.Loading)
                mManufacturer.postValue(repository.getManufacturer(manufacturerId))
            } catch (e: Exception){
                mManufacturer.postValue(ApiResult.Error("Falha ao carregar o dado", e))
            }
        }
    }

}