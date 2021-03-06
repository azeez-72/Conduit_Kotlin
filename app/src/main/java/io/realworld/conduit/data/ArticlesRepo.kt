package io.realworld.conduit.data

import io.realworld.api.ConduitClient

object ArticlesRepo {

    private val api = ConduitClient().api

    suspend fun getGlobalFeed() = api.getArticles()
}