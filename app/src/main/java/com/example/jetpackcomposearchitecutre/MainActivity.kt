package com.example.jetpackcomposearchitecutre

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcomposearchitecutre.screen.CategoryScreen
import com.example.jetpackcomposearchitecutre.screen.DetailScreen
import com.example.jetpackcomposearchitecutre.ui.theme.JetpackComposeArchitecutreTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeArchitecutreTheme {
                //CategoryScreen()
                //DetailScreen()
                Scaffold (
                    topBar = {
                        TopAppBar(title = {
                            Text(text = "Tweetsy")
                        }, backgroundColor = Color.Black, contentColor = Color.White)
                    }) {
                    Box(modifier = Modifier.padding(it)){
                        app()
                    }
                }
             }
        }
    }

    @Composable
    fun app(){
        val navigationController = rememberNavController()
        NavHost(navController = navigationController,
            startDestination = "category"){

            composable("category", arguments = listOf(
                navArgument("detail"){
                    type = NavType.StringType
                }
            )){
                CategoryScreen{
                    navigationController.navigate("detail/$it")
                }
            }
            composable("detail/{category}"){
                DetailScreen()
            }
        }
    }

//    @Composable
//    fun LoginScreen(navigation: (email:String)->Unit){
//        Text(text = "Login Screen are",
//        modifier = Modifier.clickable {
//            navigation("davindersyal@gmail.com")
//        })
//    }
//    @Composable
//    fun RegisterScreen(information: String?) {
//        Text(text = "Register Screen are${information}")
//    }
//    @Composable
//    fun DetailScreen(){
//        Text(text = "Detail Screen are")
//    }
//
//    @Composable
//    fun app(){
//        val navController = rememberNavController()
//        NavHost(navController = navController, startDestination = "login" ){
//            composable("login"){
//                LoginScreen {
//                    navController.navigate("register/${it}")
//                }
//            }
//            composable("register/{detail}", arguments = listOf(
//                navArgument("detail"){
//                    type = NavType.StringType
//                }
//            )){
//               var information =  it.arguments!!.getString("detail")
//                RegisterScreen(information)
//            }
//            composable(route = "detail"){
//                DetailScreen()
//            }
//
//        }
//    }

}