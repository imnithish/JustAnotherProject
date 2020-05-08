package com.imnstudios.justanotherproject.ui.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.imnstudios.justanotherproject.R
import com.imnstudios.justanotherproject.databinding.ActivityLoginBinding
import com.imnstudios.justanotherproject.util.toast

class LoginActivity : AppCompatActivity(), AuthListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityLoginBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)

        binding.viewmodel = viewModel

        viewModel.authListener = this
    }

    override fun onStarted() {
        toast("Login Started")

    }

    override fun onSuccess() {
        toast("Login Success")

    }

    override fun onFailure(message: String) {
        toast(message)
    }
}
