package com.example.githubrepositories.ui.screens.repo_list_screen.viewmodel

import androidx.lifecycle.ViewModel
import com.example.githubrepositories.domain.usecase.FetchGithubRepoListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

// get the data from domain in the use case to put it in the screen
@HiltViewModel // for hilt
class RepoListViewModel @Inject constructor(
    private val fetchGithubRepoListUseCase: FetchGithubRepoListUseCase
) : ViewModel() {

    // doing the request only once
    // this is better than using LaunchedEffect
    // it's drawback is in testing
//    init {
//        requestGithubRepoList()
//    }

    // get the data from the Use Case
    fun requestGithubRepoList() {
        val githubRepoListDomainModel = fetchGithubRepoListUseCase()
    }
}


