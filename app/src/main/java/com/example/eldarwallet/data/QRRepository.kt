package com.example.eldarwallet.data

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.example.eldarwallet.data.network.RapidApiService
import javax.inject.Inject


class QRRepository @Inject constructor(
    private val api: RapidApiService
) {

    suspend fun getQR(content: String): Bitmap? {

        return try {
            val response = api.getQR(
                content
            )
            BitmapFactory.decodeStream(response.byteStream())

        } catch (e: Exception) {
            null
        }
    }
}