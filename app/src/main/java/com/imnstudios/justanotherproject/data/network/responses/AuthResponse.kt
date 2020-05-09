package com.imnstudios.justanotherproject.data.network.responses

import com.imnstudios.justanotherproject.data.db.entities.User


data class AuthResponse(
    val isSuccessful: Boolean?,
    val message: String?,
    val user: User?
)
