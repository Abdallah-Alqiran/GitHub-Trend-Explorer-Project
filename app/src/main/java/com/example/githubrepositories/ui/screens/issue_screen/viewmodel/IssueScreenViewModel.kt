package com.example.githubrepositories.ui.screens.issue_screen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubrepositories.domain.model.CustomExceptionDomainModel
import com.example.githubrepositories.domain.usecase.FetchGithubRepoIssuesUseCase
import com.example.githubrepositories.ui.mapper.toCustomExceptionUiModel
import com.example.githubrepositories.ui.mapper.toRepositoryIssuesUiModel
import com.example.githubrepositories.ui.screens.issue_screen.RepoIssuesUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IssueScreenViewModel @Inject constructor(
    private val fetchGithubRepoIssuesUseCase: FetchGithubRepoIssuesUseCase
): ViewModel() {

    private val _repoIssuesStateFlow: MutableStateFlow<RepoIssuesUiState> = MutableStateFlow(RepoIssuesUiState.InitialState)
    val repoIssuesStateFlow: StateFlow<RepoIssuesUiState> = _repoIssuesStateFlow

    fun requestGithubRepoIssues(
        owner: String, name: String
    ) {
        _repoIssuesStateFlow.value = RepoIssuesUiState.Loading(isLoading = true)

        viewModelScope.launch(Dispatchers.IO) {
            try {
                _repoIssuesStateFlow.value = RepoIssuesUiState.Loading(isLoading = false)
                val data = fetchGithubRepoIssuesUseCase(owner, name)
                _repoIssuesStateFlow.value = RepoIssuesUiState.RepoIssueUiModelData(
                    repositoryIssues = data.map { it.toRepositoryIssuesUiModel() }
                )
            } catch(e: CustomExceptionDomainModel) {
                _repoIssuesStateFlow.value = RepoIssuesUiState.Loading(isLoading = false)
                _repoIssuesStateFlow.value = RepoIssuesUiState.Error(customErrorExceptionUiModel = e.toCustomExceptionUiModel())
            }
        }
    }
}