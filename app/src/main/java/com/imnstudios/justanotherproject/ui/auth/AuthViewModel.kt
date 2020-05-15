package com.imnstudios.justanotherproject.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.imnstudios.justanotherproject.data.repositories.UserRepository
import com.imnstudios.justanotherproject.util.ApiException
import com.imnstudios.justanotherproject.util.Coroutines
import com.imnstudios.justanotherproject.util.NoInternetException

class AuthViewModel(
    private val repository: UserRepository
) : ViewModel() {
    var email: String? = null
    var password: String? = null

    var authListener: AuthListener? = null

    fun getLoggedInUser() = repository.getUser()


    fun onLoginButtonClick(view: View) {
        authListener?.onStarted()

        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListener?.onFailure("Invalid email or password")
            return
        }

        Coroutines.main {
            try {

                val authResponse = repository.userLogin(email!!, password!!)
                authResponse.user?.let {

                    authListener?.onSuccess(it)
                    repository.saveUser((it))
                    return@main
                }
                authListener?.onFailure(authResponse?.message!!)

            } catch (e: ApiException) {
                authListener?.onFailure(e.message!!)
            } catch (e: NoInternetException){
                authListener?.onFailure(e.message!!)
            }


        }

    }
}