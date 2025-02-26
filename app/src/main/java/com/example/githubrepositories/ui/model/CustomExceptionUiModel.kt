package com.example.githubrepositories.ui.model

sealed class CustomExceptionUiModel {
    data object NoInternetConnection: CustomExceptionUiModel()
    data object Network: CustomExceptionUiModel()
    data object Timeout: CustomExceptionUiModel()
    data object ServiceUnreachable: CustomExceptionUiModel()
    data object Unknown: CustomExceptionUiModel()
}