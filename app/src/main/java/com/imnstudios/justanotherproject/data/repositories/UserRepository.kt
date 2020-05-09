package com.imnstudios.justanotherproject.data.repositories

import com.imnstudios.justanotherproject.data.network.MyApi
import com.imnstudios.justanotherproject.data.network.SafeApiRequest
import com.imnstudios.justanotherproject.data.network.responses.AuthResponse

class UserRepository : SafeApiRequest() {

    suspend fun userLogin(email: String, password: String): AuthResponse {


        return apiRequest { MyApi().userLogin(email, password) }
    }
}