package com.example.cleanerrorhandler.data

import com.example.cleanerrorhandler.domain.AuthRepository
import com.example.cleanerrorhandler.domain.DataError
import com.example.cleanerrorhandler.domain.Result
import com.example.cleanerrorhandler.domain.User
import retrofit2.HttpException
import java.io.IOException

class AuthRepositoryImpl: AuthRepository {
    override suspend fun registerUser(password: String): Result<User, DataError> {
        //Mimic an API call
        return try {
            val user = User("Dummy Name", "Dummy Email", "Dummy Token")
            Result.Success(user)
        }catch (e: HttpException){
            when (e.code()){
                408 -> Result.Error(DataError.Network.REQUEST_TIMEOUT)
                500 -> Result.Error(DataError.Network.SERVER_ERROR)
                413 -> Result.Error(DataError.Network.PAYLOAD_ERROR)
                else -> Result.Error(DataError.Network.UNKNOWN)
            }
        }catch (e: IOException){
            Result.Error(DataError.Network.NO_INTERNET)
        }
    }
}