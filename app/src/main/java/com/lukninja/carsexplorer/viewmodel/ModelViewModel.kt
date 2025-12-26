package com.lukninja.carsexplorer.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lukninja.carsexplorer.service.model.entity.ModelEntity
import com.lukninja.carsexplorer.service.repository.MakeRepository
import com.lukninja.carsexplorer.service.repository.ModelRepository
import com.lukninja.carsexplorer.service.util.ApiResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ModelViewModel@Inject constructor (
    private val repository: ModelRepository
) : ViewModel() {

    private val mModelList = MutableLiveData<ApiResult<List<ModelEntity>>>()
    val modelList: LiveData<ApiResult<List<ModelEntity>>> = mModelList

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