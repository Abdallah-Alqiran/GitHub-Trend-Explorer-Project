package com.example.githubrepositories.ui.screens.repo_list_screen.priview

import com.example.githubrepositories.R
import com.example.githubrepositories.ui.screens.repo_list_screen.model.GitHubRepoUIModel

val fakeGitHubRepoUIModel0 = GitHubRepoUIModel(
    id = 0,
    name = "Fitness App",
    avatar = R.drawable.happy_face.toString(),
    description = "DEPI Graduation Project",
    stars = 765,
    owner = "My Team"
)

val fakeGitHubRepoUIModel1 = GitHubRepoUIModel(
    id = 1,
    name = "Fitness App",
    avatar = R.drawable.face.toString(),
    description = "DEPI Graduation Project",
    stars = 765,
    owner = "My Team"
)
val fakeGitHubRepoUIModel2 = GitHubRepoUIModel(
    id = 2,
    name = "Places in Qena",
    avatar = R.drawable.kotlin_logo.toString(),
    description = "SignIn & Places App: SignIn validation, dynamic Qena places list, smooth RecyclerView animations.",
    stars = 765,
    owner = "Abdallah Alqiran"
)
val fakeGitHubRepoUIModel3 = GitHubRepoUIModel(
    id = 3,
    name = "GitHub Trend Explorer Project",
    avatar = R.drawable.my_bad_logo.toString(),
    description = "This is a task assigned to us as part of the Digital Egypt Pioneers Initiative (DEPI). In this project, working on creating a platform to display popular GitHub repositories.",
    stars = 765,
    owner = "Abdallah Alqiran"
)

val fakeGitHubRepoListUIModel = listOf(
    fakeGitHubRepoUIModel0,
    fakeGitHubRepoUIModel1,
    fakeGitHubRepoUIModel2,
    fakeGitHubRepoUIModel3,
    fakeGitHubRepoUIModel1.copy(id = 4),
    fakeGitHubRepoUIModel2.copy(id = 5),
    fakeGitHubRepoUIModel3.copy(id = 6),
    fakeGitHubRepoUIModel1.copy(id = 7),
    fakeGitHubRepoUIModel2.copy(id = 8),
    fakeGitHubRepoUIModel3.copy(id = 9),
    fakeGitHubRepoUIModel1.copy(id = 10),
    fakeGitHubRepoUIModel2.copy(id = 11),
    fakeGitHubRepoUIModel3.copy(id = 12),

)