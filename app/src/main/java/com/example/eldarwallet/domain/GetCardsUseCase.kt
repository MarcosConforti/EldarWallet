package com.example.eldarwallet.domain

import com.example.eldarwallet.data.CardRepository
import com.example.eldarwallet.data.model.CardModel
import javax.inject.Inject

class GetCardsUseCase @Inject constructor(private val cardRepository: CardRepository) {
    suspend operator fun invoke(): List<CardModel> {
        return cardRepository.getCards()
    }
}