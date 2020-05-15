package com.imnstudios.justanotherproject.ui.home.profile

import androidx.lifecycle.ViewModel
import com.imnstudios.justanotherproject.data.repositories.UserRepository

class ProfileViewModel(repository: UserRepository) : ViewModel() {

    val user = repository.getUser()
}
