package com.example.githubrepositories.data.repository

import com.example.githubrepositories.data.datasources.remote.GithubReposRemoteDataSource
import com.example.githubrepositories.data.mapper.toGithubRepoDomainModel
import com.example.githubrepositories.domain.model.GithubRepoDomainModel
import com.example.githubrepositories.domain.repository.GithubReposRepository
import com.example.githubrepositories.ui.screens.repo_list_screen.model.GitHubRepoUIModel

// contact the remote data source
class GithubRepositoryImp(
    // remoteDataSource
    private val githubReposRemoteDataSource: GithubReposRemoteDataSource
    // localDataSource
): GithubReposRepository {
    // create this interface in the domain repository
    override fun fetchGithubRepos(): List<GithubRepoDomainModel> {
        return githubReposRemoteDataSource.fetchGithubRepos().toGithubRepoDomainModel()
    }

}