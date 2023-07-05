package com.sushant.simpsoncharacterviewer.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sushant.simpsoncharacterviewer.repository.SimpsonsRepository
import com.sushant.simpsoncharacterviewer.viewmodel.SimpsonsViewModel

class SimpsonsViewModelFactory constructor(private val simpsonsRepository: SimpsonsRepository):
ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(SimpsonsViewModel::class.java)) {
            SimpsonsViewModel(this.simpsonsRepository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}