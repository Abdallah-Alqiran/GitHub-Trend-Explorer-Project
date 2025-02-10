package com.example.githubrepositories.domain.repository

import com.example.githubrepositories.domain.model.GithubRepoDomainModel
import com.example.githubrepositories.ui.screens.repo_list_screen.model.GitHubRepoUIModel

interface GithubReposRepository {
    fun fetchGithubRepos(): List<GithubRepoDomainModel>
}