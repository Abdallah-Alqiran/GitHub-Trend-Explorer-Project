package com.example.githubrepositories.data.mapper

import com.example.githubrepositories.data.datasources.remote.retrofit.model.GithubReposDataModel
import com.example.githubrepositories.model.GitHubRepoUIModel

fun GithubReposDataModel.toGithubRepoDomainModel(): List<GitHubRepoUIModel> {
    return this.items.map { item ->
        GitHubRepoUIModel(
            id = item.id,
            title = item.name,
            // watch out here I have it int and in the real case it's string
            avatar = item.owner.avatar_url.toInt(),
            description = item.description,
            stars = item.stargazers_count,
            owner = item.owner.login
        )
    }
}
