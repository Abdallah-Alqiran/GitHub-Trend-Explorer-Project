package com.example.githubrepositories.data.mapper

import com.example.githubrepositories.data.datasources.remote.retrofit.model.GithubReposDataModel
import com.example.githubrepositories.domain.model.GithubRepoDomainModel
import com.example.githubrepositories.ui.screens.repo_list_screen.model.GitHubRepoUIModel
// creating extension function to return Github repo model
// that we will pass to the UI later and put it in the screen
fun GithubReposDataModel.toGithubRepoDomainModel(): List<GithubRepoDomainModel> {
    return this.items.map { item ->
        GithubRepoDomainModel(
            id = item.id,
            name = item.name,
            avatar = item.owner.avatar_url,
            description = item.description,
            stars = item.stargazers_count,
            owner = item.owner.login
        )
    }
}
