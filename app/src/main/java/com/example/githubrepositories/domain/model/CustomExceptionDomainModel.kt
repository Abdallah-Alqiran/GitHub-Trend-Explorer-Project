package com.example.githubrepositories.domain.model

sealed class CustomExceptionDomainModel: Exception() {
    data object NoInternetConnectionExceptionDomainModel: CustomExceptionDomainModel() {
        private fun readResolve(): Any = NoInternetConnectionExceptionDomainModel
    }
    data object TimeoutExceptionDomainModel: CustomExceptionDomainModel() {
        private fun readResolve(): Any = TimeoutExceptionDomainModel
    }
    data object NetworkExceptionDomainModel: CustomExceptionDomainModel() {
        private fun readResolve(): Any = NetworkExceptionDomainModel
    }
    data object ServiceNotFoundExceptionDomainModel: CustomExceptionDomainModel() {
        private fun readResolve(): Any = ServiceNotFoundExceptionDomainModel
    }
    data object AccessDeniedExceptionDomainModel: CustomExceptionDomainModel() {
        private fun readResolve(): Any = AccessDeniedExceptionDomainModel
    }
    data object ServiceUnavailableExceptionDomainModel: CustomExceptionDomainModel() {
        private fun readResolve(): Any = ServiceUnavailableExceptionDomainModel
    }

    data object UnKnownExceptionDomainModel: CustomExceptionDomainModel() {
        private fun readResolve(): Any = UnKnownExceptionDomainModel
    }
}