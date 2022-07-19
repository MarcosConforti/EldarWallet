package com.example.eldarwallet.core.di

import com.example.eldarwallet.data.network.RapidApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class RapidApiRetrofit

    @Singleton
    @Provides
    @RapidApiRetrofit
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://neutrinoapi-qr-code.p.rapidapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideAPIService(@RapidApiRetrofit retrofit: Retrofit): RapidApiService {
        return retrofit.create(RapidApiService::class.java)
    }
}