package com.example.githubrepositories.domain.usecase

import com.example.githubrepositories.domain.model.GithubRepoIssuesDomainModel
import com.example.githubrepositories.domain.repository.GithubReposRepository
import javax.inject.Inject

class FetchGithubRepoIssuesUseCase @Inject constructor(
    private val githubRepository: GithubReposRepository
) {
    suspend operator fun invoke(
        owner: String, name: String
    ): GithubRepoIssuesDomainModel {
        return githubRepository.fetchGithubReposIssues(owner, name)
    }

}
