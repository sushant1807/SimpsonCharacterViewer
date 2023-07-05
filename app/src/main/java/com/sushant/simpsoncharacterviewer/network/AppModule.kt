package com.sushant.simpsoncharacterviewer.network

import com.sushant.simpsoncharacterviewer.model.SimpsonsModel
import com.sushant.simpsoncharacterviewer.util.Constants
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

//@Module
//@InstallIn(SingletonComponent::class)
//object AppModule {
//
//    @Singleton
//    @Provides
//    fun provideGsonBuilder(): Gson{
//        return GsonBuilder()
//            .excludeFieldsWithoutExposeAnnotation()
//            .create()
//    }
//
//    @Singleton
//    @Provides
//    fun provideRetrofit(gson: Gson): Retrofit.Builder {
//        return Retrofit.Builder()
//            .baseUrl(Constants.BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create(gson))
//    }
//
//    @Singleton
//    @Provides
//    fun provideService(retrofit: Retrofit.Builder): RetroServiceInstance {
//        return retrofit
//            .build()
//            .create(RetroServiceInstance::class.java)
//    }
//
//
//}

interface AppModule {

    @GET("?q=simpsons+characters&format=json")
    suspend fun getSimpsonsCharacterData(): Response<SimpsonsModel>

    companion object {
        var retrofitService: AppModule? = null

        fun getInstance() : AppModule {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(AppModule::class.java)
            }
            return retrofitService!!
        }
    }

}