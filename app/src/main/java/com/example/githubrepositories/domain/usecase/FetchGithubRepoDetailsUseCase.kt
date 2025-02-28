package com.example.githubrepositories.domain.usecase

import com.example.githubrepositories.domain.model.GithubRepoDetailsDomainModel
import com.example.githubrepositories.domain.repository.GithubReposRepository
import javax.inject.Inject

class FetchGithubRepoDetailsUseCase @Inject constructor(
    private val githubRepository: GithubReposRepository
){
    suspend operator fun invoke(
        owner: String, name: String
    ): GithubRepoDetailsDomainModel {
        return githubRepository.fetchGithubReposDetails(owner, name)
    }
}