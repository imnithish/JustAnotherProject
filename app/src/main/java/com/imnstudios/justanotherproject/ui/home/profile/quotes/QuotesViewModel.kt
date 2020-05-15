package com.imnstudios.justanotherproject.ui.home.profile.quotes

import androidx.lifecycle.ViewModel
import com.imnstudios.justanotherproject.data.repositories.QuotesRepository
import com.imnstudios.justanotherproject.util.lazyDeferred


class QuotesViewModel(
    repository: QuotesRepository
) : ViewModel() {

    val quotes by lazyDeferred {
        repository.getQuotes()
    }
}
