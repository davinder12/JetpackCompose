package com.example.jetpackcomposearchitecutre.api

import com.example.jetpackcomposearchitecutre.models.TweetList
import com.example.jetpackcomposearchitecutre.models.TweetsDetail
import retrofit2.Response
import retrofit2.http.GET

interface TweetsyApi {

  @GET("/v3/b/65b84eb2dc746540189d826c?meta=false")
  suspend  fun getTweetCategory(): Response<TweetList>

  @GET("/v3/b/65b85361dc746540189d83f1?meta=false")
  suspend fun getTweetDetail(): Response<TweetsDetail>

  @GET("/todos/1")
  suspend fun getDummy(): Response<Object>

}