package com.imnstudios.justanotherproject.ui.auth

import com.imnstudios.justanotherproject.data.db.entities.User

interface AuthListener {


    fun onStarted()
    fun onSuccess(user: User)
    fun onFailure(message: String)
}