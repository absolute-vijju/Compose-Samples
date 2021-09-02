package com.developer.vijay.composesample.demos

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.google.gson.Gson


@ExperimentalMaterialApi
@Composable
fun NavigationApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "user_list_screen") {
        composable("user_list_screen") {
            UserListScreen(navController, getData())
        }
        composable(
            "user_detail_screen/{user}",
            arguments = listOf(navArgument("user") {
                type = NavType.StringType
//                defaultValue = "Test"
//                nullable = true
            })
        ) { navBackStackEntry ->
            val userStr = navBackStackEntry.arguments?.getString("user").let {
                UserDetailScreen(user = Gson().fromJson(it, User::class.java))
            }

        }
    }
}

@ExperimentalMaterialApi
@Composable
fun UserListScreen(navController: NavController, userList: List<User>) {

    fun openUserDetailScreen(user: User) {
        navController.navigate("user_detail_screen/${Gson().toJson(user)}")
    }

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            contentPadding = PaddingValues(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            itemsIndexed(userList) { index, user ->
                ItemUser(user = user) {
                    openUserDetailScreen(user)
                }
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun UserDetailScreen(user: User) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        contentAlignment = Alignment.Center,
    ) {
        ItemUser(user = user) {

        }
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun HomeScreenPreview() {
    NavigationApp()
}