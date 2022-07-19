package com.example.eldarwallet.data.network


import okhttp3.ResponseBody
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface RapidApiService {

    @Headers(
        "content-type:application/x-www-form-urlencoded",
        "X-RapidAPI-Key:a9ffaab7fdmsh91bf5f739bf1c9bp1c4111jsn9a87ff2583f4",
        "X-RapidAPI-Host:neutrinoapi-qr-code.p.rapidapi.com"
    )
    @POST("/qr-code")
    suspend fun getQR(
        @Query("content") content: String,
        @Query("width") width: Int = 128,
        @Query("height") height: Int = 128,
        @Query("fg-color") fgColor: String = "%23000000",
        @Query("bg-color") bgColor: String = "%23ffffff"
    ): ResponseBody

}
