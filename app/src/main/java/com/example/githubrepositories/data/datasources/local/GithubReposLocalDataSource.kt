package com.example.githubrepositories.data.datasources.local

import com.example.githubrepositories.data.datasources.local.room.dao.GithubReposDao
import com.example.githubrepositories.data.datasources.local.room.entities.GithubRepoEntity
import javax.inject.Inject

// this will deal with the room database
class GithubReposLocalDataSource @Inject constructor(
    private val githubReposDao: GithubReposDao
) {
    fun insertGithubRepoList(githubRepoList: List<GithubRepoEntity>) {
        githubReposDao.insertGithubRepoList(githubRepoList)
    }

    fun getGithubRepoList(): List<GithubRepoEntity> {
        return githubReposDao.getGithubRepoList()
    }

}