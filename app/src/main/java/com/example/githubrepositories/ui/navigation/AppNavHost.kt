package com.example.githubrepositories.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.githubrepositories.ui.screens.failed_loading_screen.FailedLoadingScreen
import com.example.githubrepositories.ui.screens.details_screen.DetailsScreen
import com.example.githubrepositories.ui.screens.issue_screen.IssueScreen
import com.example.githubrepositories.ui.screens.list_screen.RepoListScreen
import com.example.githubrepositories.ui.screens.splash_screen.SplashScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    onPageChange: (String, Boolean) -> Unit,
) {
    // controller
    val navController = rememberNavController()

    // Host
    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route,
        modifier = modifier
    ) {
        composable(route = Screens.RepoList.route) {
            onPageChange("Github Repositories", false)
            RepoListScreen(
                onRepoItem = {
                    navController.navigate(Screens.RepoDetails.passId(it))
                }
            )
        }

        composable(
            route = Screens.RepoDetails.route,
            arguments = listOf(navArgument(USER_ID) {
                type = NavType.StringType
            })
        ) {navBackStackEntry ->
            onPageChange("Details", true)

            val id = navBackStackEntry.arguments?.getString(USER_ID)
            id?.let {
                DetailsScreen(
                    it,
                    onDetails = {
                        navController.navigate(Screens.RepoIssues.route)
                    }
                )
            }
        }

        composable(route = Screens.RepoIssues.route) {
            onPageChange("Issues", true)
            IssueScreen()
        }

        composable(route = Screens.Splash.route) {
            onPageChange("Github Repositories", false)
            SplashScreen(
                onSplash = {
                    navController.navigate(Screens.FailedLoading.route) {
                        popUpTo(Screens.Splash.route) {
                            inclusive = true
                        }
                    }
                }
            )

        }


        composable(route = Screens.FailedLoading.route) {
            onPageChange("Github Repositories", false)
            FailedLoadingScreen(
                onFailed = {
                    navController.navigate(Screens.RepoList.route) {
                        popUpTo(Screens.FailedLoading.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }

    }
}
