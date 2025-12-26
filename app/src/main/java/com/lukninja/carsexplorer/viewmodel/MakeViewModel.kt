package com.lukninja.carsexplorer.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lukninja.carsexplorer.service.model.dto.MakeDto
import com.lukninja.carsexplorer.service.model.entity.MakeEntity
import com.lukninja.carsexplorer.service.repository.MakeRepository
import com.lukninja.carsexplorer.service.repository.local.DatabaseProvider
import com.lukninja.carsexplorer.service.util.ApiResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MakeViewModel(application: Application): AndroidViewModel(application) {

    private val repository: MakeRepository

    init {
        val db = DatabaseProvider.getDatabase(application.applicationContext)
        repository = MakeRepository(db.MakeDao())
    }

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