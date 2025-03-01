package com.example.githubrepositories.ui.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
                onRepoItemClicked = { owner, name ->
                    navController.navigate(Screens.RepoDetails.passOwnerAndName(owner, name))
                }
            )
        }

        composable(
            route = Screens.RepoDetails.route,
        ) { navBackStackEntry ->
            onPageChange("Details", true)

            val owner = navBackStackEntry.arguments?.getString(OWNER)
            val name = navBackStackEntry.arguments?.getString(NAME)

            if (name != null && owner != null) {
                DetailsScreen(
                    owner = owner,
                    name = name,
                    onDetails = {
                        navController.navigate(Screens.RepoIssues.passOwnerAndName(owner,name))
                    }
                )
            } else {
                Log.d("userName and Owner", "$owner $name")
            }
        }

        composable(route = Screens.RepoIssues.route) { navBackStackEntry ->
            onPageChange("Issues", true)

            val owner = navBackStackEntry.arguments?.getString(OWNER)
            val name = navBackStackEntry.arguments?.getString(NAME)
            if (name != null && owner != null) {
                IssueScreen(owner, name)
            }
        }
    }
}
