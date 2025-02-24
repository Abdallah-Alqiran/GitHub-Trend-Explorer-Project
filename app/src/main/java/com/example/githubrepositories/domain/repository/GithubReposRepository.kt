package com.example.githubrepositories.domain.repository

import com.example.githubrepositories.domain.model.GithubRepoDomainModel
import com.example.githubrepositories.ui.screens.repo_list_screen.model.GitHubRepoUIModel

// It's hard for hilt to handle interface,
// So we need to create module, we created it in the DI package
interface GithubReposRepository {
    suspend fun fetchGithubRepos(): List<GithubRepoDomainModel>
}