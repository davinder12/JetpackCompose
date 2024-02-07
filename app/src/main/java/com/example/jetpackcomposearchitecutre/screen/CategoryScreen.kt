package com.example.jetpackcomposearchitecutre.screen

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jetpackcomposearchitecutre.utility.DimensionResource
import com.example.jetpackcomposearchitecutre.utility.fontDimensionResource
import com.example.jetpackcomposearchitecutre.viewModels.CategoryViewModel
import com.intuit.sdp.R as D
import com.intuit.ssp.R as S
import com.example.jetpackcomposearchitecutre.R

@Composable
fun CategoryScreen(navigation : (category:String)->Unit)
{
    val categoryViewModel: CategoryViewModel = hiltViewModel()
    val category = categoryViewModel.categories.collectAsState()
    if(category.value.tweets.isEmpty()){
         Box(modifier = Modifier.fillMaxSize(1f),
         contentAlignment = Alignment.Center) {
                 Text(text = "Loading...", style = MaterialTheme.typography.h3)
         }
    }else {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(DimensionResource(D.dimen._8sdp)),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            items(category.value.tweets) {
                CategoryItem(it.category,navigation)
            }
        }
    }
}
    @Composable
    fun CategoryItem(category: String, navigation: (category:String) -> Unit)
    {
        Box(modifier = Modifier
            .padding(DimensionResource(D.dimen._10sdp))
            .size(DimensionResource(D.dimen._150sdp))
            .clip(RoundedCornerShape(DimensionResource(D.dimen._4sdp)))
            .border(3.dp, Color.Gray)
            .paint(
                painter = painterResource(id = R.drawable.wave_haikei),
                contentScale = ContentScale.Crop
            )
            .clickable {
                navigation(category)
            },
            contentAlignment = Alignment.BottomCenter
        ){
           Text(text = category,
               color = Color.Red,
               fontSize = fontDimensionResource(S.dimen._18ssp),
               modifier = Modifier.padding(DimensionResource(id = D.dimen._4sdp))
           )
        }
    }










