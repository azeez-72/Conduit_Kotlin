package io.realworld.conduit.ui.feed

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.realworld.api.models.entities.Article
import io.realworld.conduit.data.ArticlesRepo
import kotlinx.coroutines.launch

class FeedViewModel : ViewModel() {

    private val _feed = MutableLiveData<List<Article>>()

    val feed: LiveData<List<Article>> = _feed


    //thread is launched
    fun fetchGlobalFeed() = viewModelScope.launch {
        ArticlesRepo.getGlobalFeed().body()?.let {
            _feed.postValue(it.articles)   //fetches global feed and puts it inside _feed
            Log.d("API FEED","feed fetches - articles ${it.articlesCount}")
        }
    }
}