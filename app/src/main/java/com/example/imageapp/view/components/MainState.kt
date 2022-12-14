package com.example.imageapp.view.components

import com.example.imageapp.network.model.Hit

data class MainState(
    val isLoading:Boolean=false,
    val data:List<Hit> =  emptyList(),
    val error:String=""
)
