package com.imnstudios.justanotherproject.data.repositories

import com.imnstudios.justanotherproject.data.network.MyApi
import com.imnstudios.justanotherproject.data.network.responses.AuthResponse
import retrofit2.Response

class UserRepository {

    suspend fun userLogin(email: String, password: String): Response<AuthResponse> {

        return MyApi().userLogin(email, password)
    }
}