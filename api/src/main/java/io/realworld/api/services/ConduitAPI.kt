package io.realworld.api.services

import io.realworld.api.models.ArticlesResponse
import io.realworld.api.models.TagsResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ConduitAPI {

    @GET("articles")
    fun getArticles(): Call<ArticlesResponse>

    @GET("tags")
    fun getTags(): Response<TagsResponse>
}