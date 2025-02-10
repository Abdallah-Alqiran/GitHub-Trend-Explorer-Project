package com.example.githubrepositories.data.datasources.local.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.githubrepositories.data.datasources.local.room.dao.GithubReposDao
import com.example.githubrepositories.data.datasources.local.room.entities.GithubRepoEntity

// creating the database
@Database(
    entities = [GithubRepoEntity::class],
    version = 1,
    exportSchema = false
)
abstract class GithubReposDatabase : RoomDatabase() {
    abstract fun githubReposDao(): GithubReposDao
}
