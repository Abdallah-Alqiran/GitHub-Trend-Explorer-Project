package com.example.githubrepositories.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.githubrepositories.data.Constants.Companion.DATABASE_NAME
import com.example.githubrepositories.data.datasources.local.room.GithubReposDatabase
import com.example.githubrepositories.data.datasources.local.room.dao.GithubReposDao

class DatabaseModule {
    companion object {
        fun provideRoomInstance(context: Context): GithubReposDatabase {
            return Room.databaseBuilder(
                context = context,
                klass = GithubReposDatabase::class.java,
                name = DATABASE_NAME
            ).build()
        }

        fun provideGithubRepoDao(
            githubReposDatabase: GithubReposDatabase
        ): GithubReposDao {
            return githubReposDatabase.githubReposDao()
        }
    }
}