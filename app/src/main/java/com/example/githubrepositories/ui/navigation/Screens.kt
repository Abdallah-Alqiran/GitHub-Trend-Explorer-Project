package com.example.githubrepositories.ui.navigation

const val OWNER = "owner"
const val NAME = "name"

sealed class Screens(val route: String) {

    data object RepoList : Screens("repo_list_screen")

    data object RepoDetails : Screens("repo_details/{owner}/{name}") { // Changed to use /
        fun passOwnerAndName(owner: String, name: String): String {
            return "repo_details/$owner/$name" // Correctly formatted
        }
    }

    data object RepoIssues : Screens("repo_issue_screen")

}