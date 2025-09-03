package com.example.cleanerrorhandler.domain

class UserDataValidator {

    fun validatePassword(password: String): Result<Unit, PasswordError>{

        val hasDigit = password.any{it.isDigit()}
        val hasUppercase = password.any{it.isUpperCase()}

        return when {
            password.length < 8 -> Result.Error(PasswordError.TOO_SHORT)
            hasDigit.not() -> Result.Error(PasswordError.NO_DIGIT)
            hasUppercase.not() -> Result.Error(PasswordError.NO_UPPERCASE)
            else -> Result.Success(Unit)
        }
    }

    enum class PasswordError: Error{
        TOO_SHORT,
        NO_DIGIT,
        NO_UPPERCASE
    }

}