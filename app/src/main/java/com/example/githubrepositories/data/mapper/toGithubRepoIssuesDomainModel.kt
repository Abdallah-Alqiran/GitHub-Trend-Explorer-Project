package com.example.githubrepositories.data.mapper

import com.example.githubrepositories.data.datasources.remote.retrofit.model.for_issues.Issues
import com.example.githubrepositories.domain.model.GithubRepoIssuesDomainModel

fun Issues.toGithubRepoIssuesDomainModel(): List<GithubRepoIssuesDomainModel> {
    return this.map {
        GithubRepoIssuesDomainModel(
            id = it.id,
            title = it.title,
            author = it.author_association,
            state = it.state,
            date = it.createdAt,
            repositoryUrl = it.repositoryUrl
        )
    }
}