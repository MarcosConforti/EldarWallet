package com.example.eldarwallet.domain

import com.example.eldarwallet.data.CardRepository
import com.example.eldarwallet.data.database.entities.CardEntities
import com.example.eldarwallet.data.model.CardModel
import javax.inject.Inject

class GetCardsUseCase @Inject constructor(private val cardRepository: CardRepository){
    suspend operator fun invoke(): List<CardModel> {
        return cardRepository.getCards()
    }
}//usar para mostrar la lista en el menuactivity, crear recycler y adapter