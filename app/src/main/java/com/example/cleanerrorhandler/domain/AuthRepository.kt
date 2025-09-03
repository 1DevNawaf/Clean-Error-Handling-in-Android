package com.example.cleanerrorhandler.domain

interface AuthRepository {
    suspend fun registerUser(password: String): Result<User, DataError>
}

data class User(
    val fullName: String,
    val email: String,
    val token: String
)