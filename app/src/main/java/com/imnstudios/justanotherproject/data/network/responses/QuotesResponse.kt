package com.imnstudios.justanotherproject.data.network.responses

import com.imnstudios.justanotherproject.data.db.entities.Quote


data class QuotesResponse (
    val isSuccessful: Boolean,
    val quotes: List<Quote>
)