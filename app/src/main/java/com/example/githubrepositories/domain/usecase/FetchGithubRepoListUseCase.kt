package com.example.githubrepositories.domain.usecase

import com.example.githubrepositories.domain.repository.GithubReposRepository
import com.example.githubrepositories.model.GitHubRepoUIModel

class FetchGithubRepoListUseCase(private val githubReposRepository: GithubReposRepository)  {
    operator fun invoke(): List<GitHubRepoUIModel> {
        return githubReposRepository.fetchGithubRepos()
    }
}

