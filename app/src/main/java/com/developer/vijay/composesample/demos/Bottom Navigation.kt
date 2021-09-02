package com.developer.vijay.composesample.demos

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = "home") {
        composable("home") {
            HomeScreen()
        }
        composable("chat") {
            ChatScreen()
        }
        composable("settings") {
            SettingsScreen()
        }
    }
}

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Home Screen",
            fontSize = MaterialTheme.typography.h4.fontSize
        )
    }
}

@Composable
fun ChatScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Chat Screen",
            fontSize = MaterialTheme.typography.h4.fontSize
        )
    }
}

@Composable
fun SettingsScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Settings Screen",
            fontSize = MaterialTheme.typography.h4.fontSize
        )
    }
}

@ExperimentalMaterialApi
@Composable
fun BottomNavigation(
    bottomNavigationItems: List<BottomNavigationItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onClick: (BottomNavigationItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.LightGray,
        elevation = 4.dp
    ) {
        bottomNavigationItems.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onClick(item) },
                selectedContentColor = Color.Green,
                unselectedContentColor = Color.DarkGray,
                icon = {
                    Column(horizontalAlignment = CenterHorizontally) {

                        if (item.badgeCount > 0) {
                            BadgeBox(badgeContent = {
                                Text(text = item.badgeCount.toString())
                            }) {
                                Icon(imageVector = item.icon, contentDescription = item.name)
                            }
                        } else
                            Icon(imageVector = item.icon, contentDescription = item.name)

                        if (selected) {
                            Text(
                                text = item.name,
                                textAlign = TextAlign.Center,
                                fontSize = MaterialTheme.typography.body2.fontSize
                            )
                        }
                    }
                }
            )
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun BottomNavigationApp() {
    val navController = rememberNavController()
    Scaffold(bottomBar = {
        BottomNavigation(
            bottomNavigationItems = listOf(
                BottomNavigationItem("Home", "home", Icons.Default.Home, 0),
                BottomNavigationItem("Chat", "chat", Icons.Default.Notifications, 10),
                BottomNavigationItem("Settings", "settings", Icons.Default.Settings, 0)
            ), navController = navController, onClick = {
                navController.navigate(it.route) {
                    // Pop up to the start destination of the graph to
                    // avoid building up a large stack of destinations
                    // on the back stack as users select items
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    // Avoid multiple copies of the same destination when
                    // re-selecting the same item
                    launchSingleTop = true
                    // Restore state when re-selecting a previously selected item
                    restoreState = true
                }
            }
        )
    }) {
        Navigation(navHostController = navController)
    }
}

data class BottomNavigationItem(
    val name: String,
    val route: String,
    val icon: ImageVector,
    val badgeCount: Int = 0
)