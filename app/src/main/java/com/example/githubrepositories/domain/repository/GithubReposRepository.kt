package com.example.githubrepositories.domain.repository

import com.example.githubrepositories.model.GitHubRepoUIModel

interface GithubReposRepository {
    fun fetchGithubRepos(): List<GitHubRepoUIModel>
}