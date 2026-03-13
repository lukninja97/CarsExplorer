package com.lukninja.carsexplorer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lukninja.carsexplorer.service.model.entity.ManufacturerEntity
import com.lukninja.carsexplorer.service.repository.ManufacturerRepository
import com.lukninja.carsexplorer.service.util.ApiResult
import com.lukninja.carsexplorer.util.safeApiCall
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ManufacturerViewModel @Inject constructor(
    private val repository: ManufacturerRepository
) : ViewModel() {

    private val _manufacturerList = MutableLiveData<ApiResult<List<ManufacturerEntity>>>()
    val manufacturerList: LiveData<ApiResult<List<ManufacturerEntity>>> = _manufacturerList

    private val _manufacturer = MutableLiveData<ApiResult<ManufacturerEntity>>()
    val manufacturer: LiveData<ApiResult<ManufacturerEntity>> = _manufacturer


    fun loadManufactures(make: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _manufacturerList.safeApiCall { repository.getManufactures(make) }
        }
    }

    fun getManufacturer(manufacturerId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _manufacturer.safeApiCall { repository.getManufacturer(manufacturerId) }
        }
    }

}