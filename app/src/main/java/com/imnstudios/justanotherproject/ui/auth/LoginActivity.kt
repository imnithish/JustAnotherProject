package com.imnstudios.justanotherproject.ui.auth

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.imnstudios.justanotherproject.R
import com.imnstudios.justanotherproject.data.db.entities.User
import com.imnstudios.justanotherproject.databinding.ActivityLoginBinding
import com.imnstudios.justanotherproject.util.hide
import com.imnstudios.justanotherproject.util.show
import com.imnstudios.justanotherproject.util.toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), AuthListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityLoginBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)

        binding.viewmodel = viewModel

        viewModel.authListener = this
    }

    override fun onStarted() {
        progress_bar.show()

    }

    override fun onSuccess(user: User) {
        progress_bar.hide()
        toast("${user.name} is Logged In")
    }

    override fun onFailure(message: String) {
        progress_bar.hide()
        toast(message)
    }
}
