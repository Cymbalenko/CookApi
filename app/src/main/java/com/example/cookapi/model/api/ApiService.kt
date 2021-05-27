package com.example.cookapi.model.api

import com.example.cookapi.model.api.responses.Recept
import com.example.cookapi.model.api.responses.ReceptList
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("search")
    fun getRecepts(
        @Query("q") q:String
    ): Single<List<Recept>>

    @GET("search")
    fun getListRecepts(
        @Query("q") q:String
    ): Single<ReceptList>


}