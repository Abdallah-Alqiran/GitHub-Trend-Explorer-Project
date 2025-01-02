package com.example.githubrepositories.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.githubrepositories.ui.screens.repo_details_screen.DetailsScreen
import com.example.githubrepositories.ui.screens.repo_issue_screen.IssueScreen
import com.example.githubrepositories.ui.screens.repo_list_screen.RepoListScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    onTitleChange: (String) -> Unit
) {
    // controller

    val navController = rememberNavController()

    // Host
    NavHost(
        navController = navController,
        startDestination = Screens.RepoList.route,
        modifier = modifier
    ) {
        composable(route = Screens.RepoList.route) {
            onTitleChange("Github Repositories")

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
            onTitleChange("Details")

            val id = navBackStackEntry.arguments?.getString(USER_ID)
            id?.let {
                DetailsScreen(it)
            }
        }



        composable(route = Screens.RepoIssues.route) {
            onTitleChange("Issues")

            IssueScreen()
        }
    }
}
