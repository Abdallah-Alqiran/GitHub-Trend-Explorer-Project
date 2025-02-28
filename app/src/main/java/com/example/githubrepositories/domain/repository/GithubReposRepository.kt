package com.example.githubrepositories.domain.repository

import com.example.githubrepositories.domain.model.GithubRepoDetailsDomainModel
import com.example.githubrepositories.domain.model.GithubRepoIssuesDomainModel
import com.example.githubrepositories.domain.model.GithubRepoListDomainModel

// It's hard for hilt to handle interface,
// So we need to create module, we created it in the DI package
interface GithubReposRepository {
    suspend fun fetchGithubReposList(): List<GithubRepoListDomainModel>
    suspend fun fetchGithubReposDetails(owner: String, name: String): GithubRepoDetailsDomainModel
    suspend fun fetchGithubReposIssues(owner: String, name: String): GithubRepoIssuesDomainModel

}