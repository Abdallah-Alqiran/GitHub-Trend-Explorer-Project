package com.example.githubrepositories.domain.usecase

import com.example.githubrepositories.domain.model.GithubRepoListDomainModel
import com.example.githubrepositories.domain.repository.GithubReposRepository
import javax.inject.Inject

// inject constructor
// here we have also dependency, so we will go to the dependency class and inject it
class FetchGithubRepoListUseCase @Inject constructor(
    private val githubReposRepository: GithubReposRepository
) {
    suspend operator fun invoke(): List<GithubRepoListDomainModel> {
        return githubReposRepository.fetchGithubReposList()
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

