package com.example.cleanerrorhandler.presentation

import androidx.lifecycle.ViewModel
import com.example.cleanerrorhandler.domain.Result
import com.example.cleanerrorhandler.domain.UserDataValidator

class UserViewModel(
    private val userDataValidator: UserDataValidator
) : ViewModel() {

    fun onRegisterClicked(password: String) {
        when (val result = userDataValidator.validatePassword(password)){
            is Result.Error -> {
                when(result.error){
                    UserDataValidator.PasswordError.TOO_SHORT -> TODO()
                    UserDataValidator.PasswordError.NO_DIGIT -> TODO()
                    UserDataValidator.PasswordError.NO_UPPERCASE -> TODO()
                }
            }
            is Result.Success -> {

            }
        }
    }

}