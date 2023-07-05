package com.sushant.simpsoncharacterviewer.repository

import com.sushant.simpsoncharacterviewer.network.AppModule
import com.sushant.simpsoncharacterviewer.model.SimpsonsModel
import com.sushant.simpsoncharacterviewer.util.NetworkUtil

class SimpsonsRepository constructor(private val retroServiceModule: AppModule) {

    suspend fun getSimpsonsDetails() : NetworkUtil<SimpsonsModel> {
        val response = retroServiceModule.getSimpsonsCharacterData()
        return if (response.isSuccessful) {
            val responseBody = response.body()
            if (responseBody != null) {
                NetworkUtil.Success(responseBody)
            } else {
                NetworkUtil.Error(response)
            }
        } else {
            NetworkUtil.Error(response)
        }
    }
}