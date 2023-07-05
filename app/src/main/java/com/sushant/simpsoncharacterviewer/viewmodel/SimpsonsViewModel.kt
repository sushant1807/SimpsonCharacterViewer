package com.sushant.simpsoncharacterviewer.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sushant.simpsoncharacterviewer.model.SimpsonsModel
import com.sushant.simpsoncharacterviewer.repository.SimpsonsRepository
import com.sushant.simpsoncharacterviewer.util.NetworkUtil
import kotlinx.coroutines.launch

class SimpsonsViewModel constructor( private val simpsonsRepository: SimpsonsRepository): ViewModel(){

    var cityList = MutableLiveData<SimpsonsModel?>()

    fun getSimpsonsData(){

        viewModelScope.launch {
            when (val response = simpsonsRepository.getSimpsonsDetails()) {
                is NetworkUtil.Success -> {
                    cityList.postValue(response.data)
                }
                is NetworkUtil.Error -> {
                    if (response.response.code() == 401) {
                        //Display the error
                    }
                }
            }
        }
    }
}