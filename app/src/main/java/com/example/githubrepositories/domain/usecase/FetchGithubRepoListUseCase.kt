package com.example.githubrepositories.domain.usecase

import com.example.githubrepositories.domain.model.GithubRepoDomainModel
import com.example.githubrepositories.domain.repository.GithubReposRepository
import com.example.githubrepositories.ui.screens.repo_list_screen.model.GitHubRepoUIModel

class FetchGithubRepoListUseCase(private val githubReposRepository: GithubReposRepository) {
    operator fun invoke(): List<GithubRepoDomainModel> {
        return githubReposRepository.fetchGithubRepos()
    }
//    // the same but without using operator overloading (invoke)
//    fun fetchGithubRepoList(): List<GithubRepoDomainModel> {
//        return githubReposRepository.fetchGithubRepos()
//    }
}

// old way
// fetchGithubRepoListUseCase.fetchGithubRepoList()
// using invoke
// fetchGithubRepoListUseCase()

