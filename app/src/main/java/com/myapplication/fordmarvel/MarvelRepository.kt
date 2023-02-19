package com.myapplication.fordmarvel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject



class MarvelRepository @Inject constructor(
    private val service: MarvelApiService
) {
 @Inject
    suspend fun getAllCharacters() = service.getAllLists()


    }



