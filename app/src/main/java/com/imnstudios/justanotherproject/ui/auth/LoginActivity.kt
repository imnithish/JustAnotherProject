package com.imnstudios.justanotherproject.ui.auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.imnstudios.justanotherproject.R
import com.imnstudios.justanotherproject.data.db.AppDatabase
import com.imnstudios.justanotherproject.data.db.entities.User
import com.imnstudios.justanotherproject.data.network.MyApi
import com.imnstudios.justanotherproject.data.repositories.UserRepository
import com.imnstudios.justanotherproject.databinding.ActivityLoginBinding
import com.imnstudios.justanotherproject.ui.home.HomeActivity
import com.imnstudios.justanotherproject.util.hide
import com.imnstudios.justanotherproject.util.show
import com.imnstudios.justanotherproject.util.snackbar
import com.imnstudios.justanotherproject.util.toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), AuthListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val api = MyApi()
        val db = AppDatabase(this)

        val repository = UserRepository(api, db)

        val factory = AuthViewModelFactory(repository)

        val binding: ActivityLoginBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewModel = ViewModelProvider(this, factory).get(AuthViewModel::class.java)

        binding.viewmodel = viewModel

        viewModel.authListener = this

        viewModel.getLoggedInUser().observe(this, Observer { user ->
            if (user != null) {
                Intent(this, HomeActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            }
        })


    }

    override fun onStarted() {
        progress_bar.show()

    }

    override fun onSuccess(user: User) {
        progress_bar.hide()
    }

    override fun onFailure(message: String) {
        progress_bar.hide()
//        toast(message)
        root_layout.snackbar(message)
    }
}
