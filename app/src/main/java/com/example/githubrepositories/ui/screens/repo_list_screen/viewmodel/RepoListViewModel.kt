package com.example.githubrepositories.ui.screens.repo_list_screen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubrepositories.domain.model.CustomExceptionDomainModel
import com.example.githubrepositories.domain.usecase.FetchGithubRepoListUseCase
import com.example.githubrepositories.ui.mapper.toCustomExceptionUiModel
import com.example.githubrepositories.ui.mapper.toGithubRepoUiModel
import com.example.githubrepositories.ui.screens.repo_list_screen.RepoListScreenUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

// get the data from domain -> use case to put it in the screen
@HiltViewModel // for hilt
class RepoListViewModel @Inject constructor(
    private val fetchGithubRepoListUseCase: FetchGithubRepoListUseCase
) : ViewModel() {

    private val _repoListStateFlow = MutableStateFlow(RepoListScreenUiState())
    val repoListStateFlow: StateFlow<RepoListScreenUiState> = _repoListStateFlow.asStateFlow()

    // get the data from the Use Case
    fun requestGithubRepoList() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _repoListStateFlow.value = RepoListScreenUiState(isLoading = true)
                val githubRepoListDomainModel = fetchGithubRepoListUseCase()
                _repoListStateFlow.value =
                    RepoListScreenUiState(
                        gitHubRepoUIModel = githubRepoListDomainModel.map { it.toGithubRepoUiModel() }
                    )
            } catch (e: CustomExceptionDomainModel) {
                _repoListStateFlow.value = RepoListScreenUiState(
                    isError = true,
                    customErrorExceptionUiModel = e.toCustomExceptionUiModel()
                )
            }
        }
    }
}


