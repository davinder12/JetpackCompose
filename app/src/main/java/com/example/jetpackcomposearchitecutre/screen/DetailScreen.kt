package com.example.jetpackcomposearchitecutre.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jetpackcomposearchitecutre.utility.DimensionResource
import com.example.jetpackcomposearchitecutre.utility.fontDimensionResource
import com.example.jetpackcomposearchitecutre.viewModels.TweetViewModel
import com.intuit.sdp.R as D
import com.intuit.ssp.R as S

@Composable
fun DetailScreen() {
    val tweetViewModel: TweetViewModel = hiltViewModel()
    val tweetRecord = tweetViewModel.tweetDetail.collectAsState()
    LazyColumn(content = {
        items(tweetRecord.value.Android){ item ->
            TweetListItem(item.text)
        }
    })
}

@Composable
fun TweetListItem(tweet: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = D.dimen._16sdp))
         ,
        border = BorderStroke(dimensionResource(id = D.dimen._1sdp), Color.DarkGray),
    ) {
        Text(
            text = tweet,
            color = Color.Red,
            fontSize = fontDimensionResource(S.dimen._18ssp),
            modifier = Modifier.padding(DimensionResource(id = D.dimen._4sdp))
        )
    }
}   
    
    
    
    
    
    
    

