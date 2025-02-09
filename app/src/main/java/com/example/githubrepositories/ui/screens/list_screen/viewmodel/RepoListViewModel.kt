package com.example.githubrepositories.ui.screens.list_screen.viewmodel

import androidx.lifecycle.ViewModel
import com.example.githubrepositories.domain.usecase.FetchGithubRepoListUseCase

class RepoListViewModel(private val fetchGithubRepoListUseCase: FetchGithubRepoListUseCase): ViewModel() {

//    init {
//        requestGithubRepoList()
//    }

    fun requestGithubRepoList() {
        val githubRepoListDomainModel = fetchGithubRepoListUseCase()
    }
}


