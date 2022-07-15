package com.example.eldarwallet.domain

import com.example.eldarwallet.data.CardRepository
import com.example.eldarwallet.data.model.CardModel
import javax.inject.Inject

class AddCardUseCase @Inject constructor(private val cardRepository: CardRepository){
    suspend operator fun invoke(cardModel: CardModel): Boolean {
        return cardRepository.addCard(cardModel)
    }
}