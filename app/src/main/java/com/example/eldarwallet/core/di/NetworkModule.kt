package com.example.eldarwallet.core.di

import com.example.eldarwallet.data.network.RapidApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    internal fun providesLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Provides
    internal fun providesOkHttpClientBuilder(
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient.Builder =
        OkHttpClient.Builder().apply {
            loggingInterceptor.also {
                addInterceptor(it)
            }
        }

    @Provides
    internal fun providesOkHttpClient(
        builder: OkHttpClient.Builder
    ): OkHttpClient = builder
        .build()

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class RapidApiRetrofit

    @RapidApiRetrofit
    @Singleton
    @Provides
    fun provideRapidApiRetrofit(okHttpClient: OkHttpClient):Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://neutrinoapi-qr-code.p.rapidapi.com")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    @Provides
    fun provideRapidApiService(@RapidApiRetrofit retrofit: Retrofit): RapidApiService {
        return retrofit.create(RapidApiService::class.java)
    }
}