package com.lukninja.carsexplorer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lukninja.carsexplorer.service.model.Models
import com.lukninja.carsexplorer.service.repository.ModelRepository
import com.lukninja.carsexplorer.service.util.ApiResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ModelViewModel : ViewModel() {
    private val repository = ModelRepository()

    private val mModelList = MutableLiveData<ApiResult<Models>>()
    val modelList: LiveData<ApiResult<Models>> = mModelList

    fun loadModels(make: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                mModelList.postValue(ApiResult.Loading)
                mModelList.postValue(repository.getModels(make))
            } catch (e: Exception){
                mModelList.postValue(ApiResult.Error("Falha ao carregar os dados", e))
            }
        }
    }
}