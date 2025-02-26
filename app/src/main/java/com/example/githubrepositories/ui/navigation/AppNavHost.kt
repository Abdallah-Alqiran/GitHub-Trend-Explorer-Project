package com.example.githubrepositories.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.githubrepositories.ui.screens.details_screen.DetailsScreen
import com.example.githubrepositories.ui.screens.issue_screen.IssueScreen
import com.example.githubrepositories.ui.screens.repo_list_screen.RepoListScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    onPageChange: (String, Boolean) -> Unit,
    navController: NavHostController
) {

    // Host
    NavHost(
        navController = navController,
        startDestination = Screens.RepoList.route,
        modifier = modifier
    ) {
        composable(route = Screens.RepoList.route) {
            onPageChange("Github Repositories", false)
            RepoListScreen(
                onRepoItemClicked = {
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
                    it.toInt(),
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
    }
}
