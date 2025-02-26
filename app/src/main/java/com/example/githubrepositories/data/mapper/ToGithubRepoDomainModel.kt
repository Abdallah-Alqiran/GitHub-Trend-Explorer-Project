package com.example.githubrepositories.data.mapper

import com.example.githubrepositories.data.datasources.local.room.entities.GithubRepoEntity
import com.example.githubrepositories.data.datasources.remote.retrofit.model.GithubReposDataModel
import com.example.githubrepositories.domain.model.GithubRepoDomainModel


// creating extension function to return Github repo model
// that we will pass to the UI later and put it in the screen
fun GithubRepoEntity.toGithubRepoDomainModel(): GithubRepoDomainModel {
    return GithubRepoDomainModel(
        id = this.id,
        name = this.name,
        avatar = this.avatar,
        description = this.description,
        stars = this.stars,
        owner = this.owner
    )
}

