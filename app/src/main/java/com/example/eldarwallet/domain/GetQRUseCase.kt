package com.example.eldarwallet.domain

import android.graphics.Bitmap
import com.example.eldarwallet.data.CardRepository
import com.example.eldarwallet.data.QRRepository
import com.example.eldarwallet.data.model.CardModel
import javax.inject.Inject

class GetQRUseCase @Inject constructor(private val qrRepository: QRRepository){
    suspend operator fun invoke(content:String): Bitmap? {
        return qrRepository.getQR(content)
    }
}