package com.example.githubrepositories.di

import android.content.Context
import androidx.room.Room
import com.example.githubrepositories.data.Constants.Companion.DATABASE_NAME
import com.example.githubrepositories.data.datasources.local.room.database.GithubReposDatabase
import com.example.githubrepositories.data.datasources.local.room.dao.GithubReposDao

// creating room instance
class DatabaseModule {
    companion object {
        fun provideRoomInstance(context: Context): GithubReposDatabase {
            return Room.databaseBuilder(
                context = context,
                klass = GithubReposDatabase::class.java,
                name = DATABASE_NAME
            ).build()
        }

        // we create it in separate function because if we have too much interfaces (DAOs)
        // will can use the same instance for this room database
        fun provideGithubRepoDao(
            githubReposDatabase: GithubReposDatabase
        ): GithubReposDao {
            return githubReposDatabase.githubReposDao()
        }
    }
}