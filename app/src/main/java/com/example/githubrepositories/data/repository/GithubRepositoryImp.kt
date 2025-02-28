package com.example.githubrepositories.data.repository

import android.util.Log
import com.example.githubrepositories.data.datasources.local.GithubReposLocalDataSource
import com.example.githubrepositories.data.datasources.remote.GithubReposRemoteDataSource
import com.example.githubrepositories.data.mapper.toGithubRepoDetailsDomainModel
import com.example.githubrepositories.data.mapper.toGithubRepoEntity
import com.example.githubrepositories.domain.model.GithubRepoDetailsDomainModel
import com.example.githubrepositories.domain.model.GithubRepoListDomainModel
import com.example.githubrepositories.domain.repository.GithubReposRepository
import javax.inject.Inject

// contact the remote data source
class GithubRepositoryImp @Inject constructor(
    // remoteDataSource
    private val githubReposRemoteDataSource: GithubReposRemoteDataSource,
    // localDataSource
    private val githubReposLocalDataSource: GithubReposLocalDataSource
) : GithubReposRepository {

    // create this interface in the domain repository
    override suspend fun fetchGithubReposList(): List<GithubRepoListDomainModel> {
        // check if user first time to enter app
        return if (githubReposLocalDataSource.readIsFirstTimeEnterApp()) {
            // first time:
            // get data from API
            val githubReposDataModel = githubReposRemoteDataSource.fetchGithubRepos()

            // then cache in ROOM
            githubReposLocalDataSource.insertGithubRepoList(githubReposDataModel.items.map { it.toGithubRepoEntity() })

            // then return cached data
            githubReposLocalDataSource.saveIsFirstTimeEnterApp(isFirstTime = false)
            githubReposLocalDataSource.getGithubRepoList().map { it.toGithubRepoDetailsDomainModel() }
        } else {
            // not first time

            // return cached data
            githubReposLocalDataSource.getGithubRepoList().map { it.toGithubRepoDetailsDomainModel() }
        }
    }

    // create this interface in the domain repository
    override suspend fun fetchGithubReposDetails(
        owner: String,
        name: String
    ): GithubRepoDetailsDomainModel {
        return githubReposRemoteDataSource.fetchGithubRepositoryDetails(owner, name).toGithubRepoDetailsDomainModel()
    }

}