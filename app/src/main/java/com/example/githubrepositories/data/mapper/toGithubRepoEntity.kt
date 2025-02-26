package com.example.githubrepositories.data.mapper

import com.example.githubrepositories.data.datasources.local.room.entities.GithubRepoEntity
import com.example.githubrepositories.data.datasources.remote.retrofit.model.Item

fun Item.toGithubRepoEntity(): GithubRepoEntity {
    return GithubRepoEntity (
        id = id,
        name = name,
        avatar = owner.avatar_url,
        description = description,
        forks = forks,
        language = language?: "",
        stars = stargazers_count,
        url = url,
        owner = owner.login
    )
}