package com.example.githubrepositories.data.mapper

import com.example.githubrepositories.domain.model.CustomExceptionDomainModel
import retrofit2.HttpException
import java.io.IOException
import java.net.HttpURLConnection

fun Throwable.toCustomExceptionDomainModel(): CustomExceptionDomainModel {
    return when(this) {
        is InterruptedException -> CustomExceptionDomainModel.TimeoutExceptionDomainModel
        is IOException -> CustomExceptionDomainModel.NetworkExceptionDomainModel
        is HttpException -> {
            when (this.code()) {
                HttpURLConnection.HTTP_NOT_FOUND -> CustomExceptionDomainModel.ServiceNotFoundExceptionDomainModel
                HttpURLConnection.HTTP_FORBIDDEN -> CustomExceptionDomainModel.AccessDeniedExceptionDomainModel
                HttpURLConnection.HTTP_UNAVAILABLE -> CustomExceptionDomainModel.ServiceUnavailableExceptionDomainModel

                else -> CustomExceptionDomainModel.UnKnownExceptionDomainModel
            }
        }
        else -> CustomExceptionDomainModel.UnKnownExceptionDomainModel
    }
}