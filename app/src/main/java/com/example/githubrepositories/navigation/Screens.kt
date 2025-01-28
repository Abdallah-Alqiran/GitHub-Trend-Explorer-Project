package com.example.githubrepositories.navigation

const val USER_ID = "user_id"

sealed class Screens(val route: String) {

    data object RepoList : Screens("repo_list_screen")

    data object RepoDetails: Screens("repo_details_screen/{$USER_ID}") {
        fun passId(id: String): String {
            return "repo_details_screen/$id"
        }
    }

    data object RepoIssues: Screens("repo_issue_screen")

    data object Splash: Screens("splash_screen")

}