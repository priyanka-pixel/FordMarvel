package com.myapplication.fordmarvel

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MarvelModule {

@Singleton
@Provides
    fun provideApiService(): MarvelApiService =
        Retrofit.Builder()
            .baseUrl("https://gateway.marvel.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideOkHttpClient())
            .build()
            .create(MarvelApiService::class.java)

    @Singleton
    @Provides
    fun provideOkHttpClient():OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply{
                level = HttpLoggingInterceptor.Level.BODY
            })
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30,TimeUnit.SECONDS)
            .writeTimeout(30,TimeUnit.SECONDS)
            .build()
    @Singleton
    @Provides
    fun provideRepository(): MarvelRepository =
        MarvelRepository(provideApiService())
}