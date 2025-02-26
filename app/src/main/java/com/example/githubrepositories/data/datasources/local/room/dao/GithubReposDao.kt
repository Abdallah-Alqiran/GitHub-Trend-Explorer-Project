package com.example.githubrepositories.data.datasources.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.githubrepositories.data.datasources.local.room.entities.GithubRepoEntity

// creating Dao
// Hilt can't deal with interfaces,
// So we will handle it in the Database Module
@Dao
interface GithubReposDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE) // using bach inserting
    fun insertGithubRepoList(githubRepoEntity: List<GithubRepoEntity>)

    @Query("SELECT * FROM GITHUB_REPOS_TABLE")
    fun getGithubRepoList(): List<GithubRepoEntity>
}