package com.example.imageapp.view.components

import com.example.imageapp.network.model.ApiService
import com.example.imageapp.network.model.PixabayResponse
import com.example.imageapp.util.Constant
import com.example.imageapp.util.Resource
import java.lang.Exception
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getQueryItems(q: String): Resource<PixabayResponse> {
        return try {
            val result =  apiService.getQueryImages(query = q, apiKey = Constant.KEY, imageType = "photo")
           Resource.Success(data = result)
        } catch (e: Exception) {
            Resource.Error(message = e.message.toString())
        }
    }
}
