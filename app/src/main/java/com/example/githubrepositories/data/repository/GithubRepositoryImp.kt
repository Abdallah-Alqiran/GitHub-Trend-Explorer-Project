package com.example.githubrepositories.data.repository

import com.example.githubrepositories.data.datasources.remote.GithubReposRemoteDataSource
import com.example.githubrepositories.data.mapper.toGithubRepoDomainModel
import com.example.githubrepositories.domain.repository.GithubReposRepository
import com.example.githubrepositories.model.GitHubRepoUIModel

class GithubRepositoryImp(
    // remoteDataSource
    private val githubReposRemoteDataSource: GithubReposRemoteDataSource
    // localDataSource
): GithubReposRepository {
    override fun fetchGithubRepos(): List<GitHubRepoUIModel> {
        return githubReposRemoteDataSource.fetchGithubRepos().toGithubRepoDomainModel()
    }

}