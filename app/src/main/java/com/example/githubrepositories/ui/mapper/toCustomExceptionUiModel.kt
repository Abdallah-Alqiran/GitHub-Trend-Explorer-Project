package com.example.githubrepositories.ui.mapper

import com.example.githubrepositories.domain.model.CustomExceptionDomainModel
import com.example.githubrepositories.ui.model.CustomExceptionUiModel

fun CustomExceptionDomainModel.toCustomExceptionUiModel(): CustomExceptionUiModel {
    return when(this) {
        is CustomExceptionDomainModel.NoInternetConnectionExceptionDomainModel -> CustomExceptionUiModel.NoInternetConnection

        is CustomExceptionDomainModel.TimeoutExceptionDomainModel -> CustomExceptionUiModel.Timeout

        is CustomExceptionDomainModel.NetworkExceptionDomainModel -> CustomExceptionUiModel.Network

        is CustomExceptionDomainModel.ServiceNotFoundExceptionDomainModel,
        CustomExceptionDomainModel.AccessDeniedExceptionDomainModel,
        CustomExceptionDomainModel.ServiceUnavailableExceptionDomainModel ->CustomExceptionUiModel.ServiceUnreachable

        is CustomExceptionDomainModel.UnKnownExceptionDomainModel -> CustomExceptionUiModel.Unknown
    }
}