package com.example.githubrepositories.data

// creating constants we will use in retrofit and room
class Constants {
    companion object{
        // retrofit
        const val BASE_URL = "https://api.github.com/"
        const val END_REMOTE_URL = "repositories?q=language"

        // room
        const val GITHUB_REPOS_TABLE = "github_repos_table"
        const val DATABASE_NAME = "github_repos_database"
    }
}