package dev.lchang.countryappue.presentation.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.lchang.countryappue.presentation.auth.LoginScreen
import dev.lchang.countryappue.presentation.auth.RegisterScreen
import dev.lchang.countryappue.presentation.home.CountryListScreen

@Composable
fun NavigationMenu(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "register"){
        composable("register"){ RegisterScreen(navController)}
        composable("login"){ LoginScreen(navController)}
        composable("home"){
            DrawerScaffold(navController){
                CountryListScreen()
            }
        }

        composable("permissions"){
            DrawerScaffold(navController){
                // TODO: Permissions screen
                Text("Pantalla de permisos")
            }
        }

        composable("favorites"){
            DrawerScaffold(navController){
                // TODO: Favorites screen
                Text("Pantalla de favoritos")
            }
        }
    }

}