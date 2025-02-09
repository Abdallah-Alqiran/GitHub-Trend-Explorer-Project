package com.example.githubrepositories.data.datasources.local

import com.example.githubrepositories.data.datasources.local.room.dao.GithubReposDao
import com.example.githubrepositories.data.datasources.local.room.entities.GithubRepoEntity

class GithubReposLocalDataSource(
    private val githubReposDao: GithubReposDao
) {
    fun insertGithubRepoList(githubRepoList: List<GithubRepoEntity>) {
        githubReposDao.insertGithubRepoList(githubRepoList)
    }

    fun getGithubRepoList(): List<GithubRepoEntity> {
        return githubReposDao.getGithubRepoList()
    }

}