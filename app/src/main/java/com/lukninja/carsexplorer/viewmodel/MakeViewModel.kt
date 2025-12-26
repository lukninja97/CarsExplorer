package com.lukninja.carsexplorer.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lukninja.carsexplorer.service.model.entity.MakeEntity
import com.lukninja.carsexplorer.service.repository.MakeRepository
import com.lukninja.carsexplorer.service.util.ApiResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MakeViewModel @Inject constructor (
    private val repository: MakeRepository
): ViewModel() {

    private val mMakeList = MutableLiveData<ApiResult<List<MakeEntity>>>()
    val makeList: LiveData<ApiResult<List<MakeEntity>>> = mMakeList


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