package com.example.jetpackcomposearchitecutre.viewModels

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposearchitecutre.models.TweetList
import com.example.jetpackcomposearchitecutre.models.TweetsDetail
import com.example.jetpackcomposearchitecutre.repository.TweetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TweetViewModel  @Inject constructor(
    private val tweetRepository: TweetRepository,
    private val savedStateHandle: SavedStateHandle) : ViewModel()
{
    val tweetDetail : StateFlow<TweetsDetail>
    get() = tweetRepository.tweetsDetail

    init {
        viewModelScope.launch {
            val infromation = savedStateHandle.get<String>("category")
            Log.e("inforamtion are ==>",""+infromation)
            tweetRepository.getTweetDetail()
        }
    }
}