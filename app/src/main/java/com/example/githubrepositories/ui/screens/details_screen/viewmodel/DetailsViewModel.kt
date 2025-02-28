package com.example.githubrepositories.ui.screens.details_screen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubrepositories.domain.model.CustomExceptionDomainModel
import com.example.githubrepositories.domain.usecase.FetchGithubRepoDetailsUseCase
import com.example.githubrepositories.ui.mapper.toCustomExceptionUiModel
import com.example.githubrepositories.ui.mapper.toRepositoryDetailsUiModel
import com.example.githubrepositories.ui.screens.details_screen.RepoDetailsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val fetchGithubRepoDetailsUseCase: FetchGithubRepoDetailsUseCase
): ViewModel() {
    private val _repoDetailsStateFlow: MutableStateFlow<RepoDetailsUiState> = MutableStateFlow(RepoDetailsUiState.InitialState)
    val repoDetailsStateFlow: StateFlow<RepoDetailsUiState> = _repoDetailsStateFlow

    fun requestGithubRepoDetails(
        owner: String,
        name: String
    ) {
        _repoDetailsStateFlow.value = RepoDetailsUiState.Loading(isLoading = true)

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val data = fetchGithubRepoDetailsUseCase(owner, name)

                _repoDetailsStateFlow.value = RepoDetailsUiState.Loading(isLoading = false)
                _repoDetailsStateFlow.value = RepoDetailsUiState.RepoDetailsUiModelData(
                    repositoryDetails = data.toRepositoryDetailsUiModel()
                )

            } catch (e: CustomExceptionDomainModel) {
                _repoDetailsStateFlow.value = RepoDetailsUiState.Loading(isLoading = false)
                _repoDetailsStateFlow.value = RepoDetailsUiState.Error(customErrorExceptionUiModel = e.toCustomExceptionUiModel())
            }
        }
    }
}