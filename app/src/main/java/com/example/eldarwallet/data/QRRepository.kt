package com.example.eldarwallet.data

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.example.eldarwallet.data.network.RapidApiService
import javax.inject.Inject


class QRRepository @Inject constructor(
    private val api: RapidApiService
) {

    suspend fun getQR(content: String): Bitmap? {

        try {
            val response = api.getQR(
                "application/x-www-form-urlencoded",
                "ed3cd13856msh49f28eb21784139p1721c0jsnc080d68547c0",
                "neutrinoapi-qr-code.p.rapidapi.com",
                content
            )
            if (response.isSuccessful) {
                //es lo mismo que la condicion es null o no
                response.body()?.let { body ->
                    return BitmapFactory.decodeStream(body.byteStream())
                }
            }
            return null
        } catch (e: Exception) {
            return null
        }
    }
}