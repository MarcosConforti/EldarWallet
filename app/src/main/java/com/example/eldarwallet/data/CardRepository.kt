package com.example.eldarwallet.data

import com.example.eldarwallet.data.database.dao.CardDao
import com.example.eldarwallet.data.database.entities.CardEntities
import com.example.eldarwallet.data.model.CardModel
import java.lang.Exception
import javax.inject.Inject

class CardRepository @Inject constructor(private val cardDao: CardDao) {

    suspend fun getCards(): List<CardModel> {
        val cardList = cardDao.getAllCards()
        return cardList.map { CardModel(it.card, it.number, it.code, it.date) }
    }

    //carga tarjeta en base de datos
    suspend fun addCard(cardModel: CardModel): Boolean {
        return try {
            val entities = CardEntities(
                cardModel.cardNumber, cardModel.cardName, cardModel.cardCode,
                cardModel.expireDate
            )
            cardDao.insert(entities)
            true
        } catch (e: Exception) {
            false
        }
    }
}