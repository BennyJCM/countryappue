package dev.lchang.countryappue.presentation.navigation

import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import java.lang.reflect.Modifier
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.foundation.layout.height

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerScaffold(navController: NavHostController, content: @Composable () -> Unit){
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Spacer(Modifier.height(12.dp))
                Text("Menu principal")
                HorizontalDivider()

                NavigationDrawerItem(
                    label = {Text("Home")},
                    selected = false,
                    onClick = {
                        navController.navigate("home")
                        scope.launch{drawerState.close()}
                    }
                )
                drawerContent = {
                    //Favorites navigation
                    NavigationDrawerItem(
                        label = { Text("Favorites") },
                        selected = false,
                        onClick = {
                            navController.navigate("favorites")
                            scope.launch { drawerState.close() }
                        }
                    )
                }


            }
        }
    ) {
        //Topappbar
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "Country App")
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                scope.launch { drawerState.open() }
                            }
                        ){
                            Icon(Icons.Default.Menu, contentDescription = "Drawer Menu")
                        }
                    }
                )
            }
        ){
            paddingValues ->
            Box(
                modifier = Modifier.padding(paddingValues)
            ){
                content()
            }
        }
    }
}