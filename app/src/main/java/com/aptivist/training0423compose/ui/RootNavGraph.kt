package com.aptivist.training0423compose.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.aptivist.training0423compose.ui.detail.DetailPostView
import com.aptivist.training0423compose.ui.login.LoginView
import com.aptivist.training0423compose.ui.posts.PostsView


@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavigationScreen.LoginScreen.route,
    ) {

        composable(NavigationScreen.LoginScreen.route) {
            LoginView(navigateToPost = {
                navController.navigate(NavigationScreen.PostScreen.route)
            })
        }

        composable(NavigationScreen.PostScreen.route) {
            PostsView(navigateToDetail = { title, content ->
                navController.navigate(NavigationScreen.DetailScreen.route + "/${title}" + "/${content}")
            })
        }

        composable(NavigationScreen.DetailScreen.route + "/{id}" + "/{body}") {
            val title = it.arguments?.getString("id") ?: "Id not found"
            val body = it.arguments?.getString("body") ?: "Body not found"
            DetailPostView(title, body)
        }
    }

}

sealed class NavigationScreen(val route: String) {
    object LoginScreen : NavigationScreen(route = "LOGIN")
    object PostScreen : NavigationScreen(route = "POST")
    object DetailScreen : NavigationScreen(route = "DETAIL")
}
