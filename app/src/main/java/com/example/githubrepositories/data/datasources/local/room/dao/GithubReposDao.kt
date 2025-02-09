package com.example.githubrepositories.data.datasources.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.githubrepositories.data.datasources.local.room.entities.GithubRepoEntity

@Dao
interface GithubReposDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGithubRepoList(githubRepoEntity: List<GithubRepoEntity>)

    @Query("SELECT * FROM GITHUB_REPOS_TABLE")
    fun getGithubRepoList(): List<GithubRepoEntity>
}