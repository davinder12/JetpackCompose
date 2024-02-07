package com.example.jetpackcomposearchitecutre.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposearchitecutre.models.TweetList
import com.example.jetpackcomposearchitecutre.repository.TweetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel  @Inject constructor(private val tweetRepository: TweetRepository) : ViewModel() {
    val categories : StateFlow<TweetList>
    get() = tweetRepository.category
    init {
        viewModelScope.launch {
            tweetRepository.getCategories()
        }
    }
}