package com.dubizzle.classifieds.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dubizzle.classifieds.data.main.model.Classified
import com.dubizzle.classifieds.domain.main.usecase.ClassifiedUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val usecase: ClassifiedUseCase) : ViewModel() {

    private var _classifieds = MutableLiveData(emptyList<Classified>())
    private var _loading = MutableLiveData<Boolean>(true)
    val classifieds: LiveData<List<Classified>> = _classifieds
    val loading: LiveData<Boolean> = _loading

    fun loadClassifieds() {
        _loading.postValue(true)
        viewModelScope.launch {
            val results = usecase.classifieds().results
            withContext(Dispatchers.Main) {
                _classifieds.postValue(results)
                _loading.postValue(false)
            }
        }
    }
}

