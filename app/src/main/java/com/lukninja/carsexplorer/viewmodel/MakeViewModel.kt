package com.lukninja.carsexplorer.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lukninja.carsexplorer.service.model.entity.MakeEntity
import com.lukninja.carsexplorer.service.repository.MakeRepository
import com.lukninja.carsexplorer.service.util.ApiResult
import com.lukninja.carsexplorer.util.safeApiCall
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MakeViewModel @Inject constructor (
    private val repository: MakeRepository
): ViewModel() {

    private val _makeList = MutableLiveData<ApiResult<List<MakeEntity>>>()
    val makeList: LiveData<ApiResult<List<MakeEntity>>> = _makeList


    fun load() {
        viewModelScope.launch(Dispatchers.IO) {
            _makeList.safeApiCall { repository.getMakes() }
        }
    }
}