package com.example.githubrepositories.di

import android.content.Context
import androidx.room.Room
import com.example.githubrepositories.data.Constants.Companion.DATABASE_NAME
import com.example.githubrepositories.data.datasources.local.room.database.GithubReposDatabase
import com.example.githubrepositories.data.datasources.local.room.dao.GithubReposDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// creating room instance
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideRoomInstance(
        // The context is abstract class we can't provide from it instance,
        // So we must give him the context,
        // In this case, we will use the application context
        @ApplicationContext context: Context // @ApplicationContext is a predefined qualifier
    ): GithubReposDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = GithubReposDatabase::class.java,
            name = DATABASE_NAME
        ).build()
    }

    // we create it in separate function because if we have too much interfaces (DAOs)
    // will can use the same instance for this room database
    @Provides
    @Singleton
    fun provideGithubRepoDao(
        githubReposDatabase: GithubReposDatabase
    ): GithubReposDao {
        return githubReposDatabase.githubReposDao()
    }
}