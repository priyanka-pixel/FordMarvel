package com.myapplication.fordmarvel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val repository: MarvelRepository
    ): ViewModel() {

     val marvelLiveData = MutableLiveData<CharacterResponseModL> ()


     fun fetchMarvels() {
       viewModelScope.launch {
            val response = repository.getAllCharacters()
                if(response.isSuccessful){
                    marvelLiveData.postValue(response.body())
                }else{
                    //display error
                }
            }
        }
    }


