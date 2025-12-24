package com.lukninja.carsexplorer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lukninja.carsexplorer.service.model.Make
import com.lukninja.carsexplorer.service.repository.MakeRepository
import com.lukninja.carsexplorer.service.util.ApiResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MakeViewModel: ViewModel() {
    private val repository = MakeRepository()

    private val mMakeList = MutableLiveData<ApiResult<List<Make>>>()
    val makeList: LiveData<ApiResult<List<Make>>> = mMakeList


    fun load() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                mMakeList.postValue(ApiResult.Loading)
                mMakeList.postValue(repository.getMakes())
            } catch (e: Exception){
                mMakeList.postValue(ApiResult.Error("Falha ao carregar os dados", e))
            }
        }
    }
}