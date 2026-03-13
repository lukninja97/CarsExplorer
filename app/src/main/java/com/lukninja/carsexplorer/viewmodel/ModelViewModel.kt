package com.lukninja.carsexplorer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lukninja.carsexplorer.service.model.entity.ModelEntity
import com.lukninja.carsexplorer.service.repository.ModelRepository
import com.lukninja.carsexplorer.service.util.ApiResult
import com.lukninja.carsexplorer.util.safeApiCall
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ModelViewModel@Inject constructor (
    private val repository: ModelRepository
) : ViewModel() {

    private val _modelList = MutableLiveData<ApiResult<List<ModelEntity>>>()
    val modelList: LiveData<ApiResult<List<ModelEntity>>> = _modelList


    fun loadModels(make: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _modelList.safeApiCall { repository.getModels(make) }
        }
    }
}