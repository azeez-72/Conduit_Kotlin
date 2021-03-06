package io.realworld.api

import io.realworld.api.services.ConduitAPI
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ConduitClient {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://conduit.productionready.io/api/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val api: ConduitAPI = retrofit.create(ConduitAPI::class.java)

}