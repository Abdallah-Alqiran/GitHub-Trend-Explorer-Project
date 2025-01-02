package com.example.githubrepositories.ui.screens.repo_list_screen.preview

import com.example.githubrepositories.R
import com.example.githubrepositories.ui.screens.repo_list_screen.model.GitHubRepoUIModel

val fakeGitHubRepoUIModel1 = GitHubRepoUIModel(
    id = 1,
    title = "Fitness App",
    avatar = R.drawable.happy_face,
    description = "DEPI Graduation Project",
    stars = 765,
    owner = "My Team"
)
val fakeGitHubRepoUIModel2 = GitHubRepoUIModel(
    id = 2,
    title = "Places in Qena",
    avatar = R.drawable.happy_face,
    description = "SignIn & Places App: SignIn validation, dynamic Qena places list, smooth RecyclerView animations.",
    stars = 765,
    owner = "Abdallah Alqiran"
)
val fakeGitHubRepoUIModel3 = GitHubRepoUIModel(
    id = 3,
    title = "GitHub Trend Explorer Project",
    avatar = R.drawable.happy_face,
    description = "This is a task assigned to us as part of the Digital Egypt Pioneers Initiative (DEPI). In this project, working on creating a platform to display popular GitHub repositories.",
    stars = 765,
    owner = "Abdallah Alqiran"
)

val fakeGitHubRepoListUIModel = listOf(
    fakeGitHubRepoUIModel1,
    fakeGitHubRepoUIModel2,
    fakeGitHubRepoUIModel3
)