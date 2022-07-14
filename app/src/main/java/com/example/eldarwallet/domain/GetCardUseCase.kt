package com.example.eldarwallet.domain

import com.example.eldarwallet.data.CardRepository
import com.example.eldarwallet.data.database.entities.CardEntities
import javax.inject.Inject

class GetCardUseCase @Inject constructor(private val cardRepository: CardRepository){
    suspend operator fun invoke(): List<CardEntities> {
        return cardRepository.getCard()
    }
}