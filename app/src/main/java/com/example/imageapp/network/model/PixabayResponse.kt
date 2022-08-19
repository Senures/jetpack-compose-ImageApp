package com.example.imageapp.network.model

import com.example.imageapp.network.model.Hit

data class PixabayResponse(
    val hits: List<Hit>,
    val total: Int,
    val totalHits: Int
)