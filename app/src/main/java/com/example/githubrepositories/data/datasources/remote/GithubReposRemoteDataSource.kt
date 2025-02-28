package com.example.githubrepositories.data.datasources.remote

import android.util.Log
import com.example.githubrepositories.data.datasources.remote.retrofit.api.GithubAPI
import com.example.githubrepositories.data.datasources.remote.retrofit.api.RepoDetailsApi
import com.example.githubrepositories.data.datasources.remote.retrofit.api.RepoIssuesApi
import com.example.githubrepositories.data.datasources.remote.retrofit.model.GithubReposDataModel
import com.example.githubrepositories.data.datasources.remote.retrofit.model.IssuesItem
import com.example.githubrepositories.data.datasources.remote.retrofit.model.Item
import com.example.githubrepositories.data.mapper.toCustomExceptionDomainModel
import com.example.githubrepositories.domain.model.CustomExceptionDomainModel
import javax.inject.Inject

// this remote repo will deal with retrofit
// (go back to recommended app architecture)
// we will take instance from retrofit
class GithubReposRemoteDataSource @Inject constructor(
    private val githubAPI: GithubAPI,
    private val repoDetailsApi: RepoDetailsApi,
    private val repoIssuesApi: RepoIssuesApi
) {
    // this function will return the data if there is no errors
    suspend fun fetchGithubRepos(): GithubReposDataModel {
        return try {
            githubAPI.fetchGithubRepoData().body() as GithubReposDataModel
        } catch (e: Exception) {
            throw e.toCustomExceptionDomainModel()
        }
    }

    // this function will return the details data
    suspend fun fetchGithubRepositoryDetails(owner: String, name: String): Item {
        return try {
            repoDetailsApi.fetchRepoDetails(owner, name).body() as Item
        } catch(e: Exception) {
            throw e.toCustomExceptionDomainModel()
        }
    }

    suspend fun fetchGithubRepositoryIssues(owner: String, name: String): IssuesItem {
        return try {
            repoIssuesApi.fetchIssueDetails(owner, name).body() as IssuesItem
        } catch(e: Exception) {
            throw  e//.toCustomExceptionDomainModel()
        }
    }
}