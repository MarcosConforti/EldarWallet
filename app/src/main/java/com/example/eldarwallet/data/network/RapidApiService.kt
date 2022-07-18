package com.example.eldarwallet.data.network


import okhttp3.Response
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface RapidApiService {

    @POST("/qr-code?width=128&height=128&fg-color=%23000000&bg-color=%23ffffff")
    suspend fun getQR(
        @Header("content-type") contentType: String,
        @Header("X-RapidAPI-Key") rapidApiKey: String,
        @Header("X-RapidAPI-Host") rapidApiHost: String,
        @Query("content") content: String
    ): Response

}