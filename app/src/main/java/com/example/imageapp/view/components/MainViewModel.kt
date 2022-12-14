package com.example.imageapp.view.components

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imageapp.network.model.Hit
import com.example.imageapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
    @Inject constructor(private val mainRepository: MainRepository)
    :ViewModel() {

        val list:MutableState<MainState> = mutableStateOf((MainState()))


    fun getImageList(q:String)=viewModelScope.launch{
        val result=mainRepository.getQueryItems(q)

        when(result){
            is Resource.Loading->{
                list.value=MainState(isLoading =true)
            }
            is Resource.Error->{
                list.value= MainState(error ="something went  wrong")
            }

            is Resource.Success->{
                result.data?.hits?.let {
                    list.value=MainState(data = it)
                }

            }
        }

    }
}