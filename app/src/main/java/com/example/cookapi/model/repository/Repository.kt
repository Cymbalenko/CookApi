package com.example.cookapi.model.repository

import com.example.cookapi.model.api.ApiService
import com.example.cookapi.model.api.responses.Recept
import com.example.cookapi.model.api.responses.ReceptList
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Query

object Repository {

    private val apiService = createApiService()


    fun getRecept(q:String): Single<List<Recept>>{
        return apiService.getRecepts(q)
    }

    fun getListRecepts(q:String): Single<ReceptList>{
        return apiService.getListRecepts(q)
    }
    private fun createRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://forkify-api.herokuapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }

    private fun createApiService():ApiService{
        val retrofit= createRetrofit()
        return retrofit.create(ApiService::class.java)
    }
}