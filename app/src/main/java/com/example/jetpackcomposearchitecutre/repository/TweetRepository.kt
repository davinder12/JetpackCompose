package com.example.jetpackcomposearchitecutre.repository

import com.example.jetpackcomposearchitecutre.api.TweetsyApi
import com.example.jetpackcomposearchitecutre.models.TweetList
import com.example.jetpackcomposearchitecutre.models.TweetsDetail
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.emptyFlow
import javax.inject.Inject

class TweetRepository @Inject constructor(private val tweetsyApi: TweetsyApi) {

    private val _category = MutableStateFlow(TweetList(emptyList()))
    val category: StateFlow<TweetList>
    get() = _category

    private val _tweetDetail = MutableStateFlow(TweetsDetail(emptyList()))
    val tweetsDetail: StateFlow<TweetsDetail>
    get() = _tweetDetail

    suspend fun getCategories(){
       val response = tweetsyApi.getTweetCategory()
       if(response.isSuccessful && response.body() != null){
           _category.emit(response.body()!!)
       }
   }

    suspend fun getTweetDetail(){
        val response = tweetsyApi.getTweetDetail()
        if(response.isSuccessful && response.body() != null){
            _tweetDetail.emit(response.body()!!)
        }
    }


}