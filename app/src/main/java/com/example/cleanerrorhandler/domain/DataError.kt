package com.example.cleanerrorhandler.domain

sealed interface DataError: Error{
    enum class Network: DataError {
        REQUEST_TIMEOUT,
        TOO_MANY_REQUESTS,
        SERVER_ERROR,
        NO_INTERNET,
        PAYLOAD_ERROR,
        SERIALIZATION_ERROR,
        UNKNOWN
    }

    enum class Local: DataError {
        DISK_FULL,
        PRIVILEGES_ERROR,
        UNKNOWN
    }

}