package com.example.githubrepositories.data.mapper

import com.example.githubrepositories.data.datasources.remote.retrofit.model.IssuesItem
import com.example.githubrepositories.domain.model.GithubRepoIssuesDomainModel

fun IssuesItem.toGithubRepoIssuesDomainModel(): GithubRepoIssuesDomainModel {
    return GithubRepoIssuesDomainModel(
        title = this.title,
        body = this.body,
        locked = this.locked,
        createdAt = this.createdAt,
        repositoryUrl = this.repositoryUrl
    )
}