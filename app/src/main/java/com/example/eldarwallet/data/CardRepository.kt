package com.example.eldarwallet.data


import com.example.eldarwallet.data.database.dao.CardDao
import com.example.eldarwallet.data.database.entities.CardEntities
import javax.inject.Inject

class CardRepository @Inject constructor(private val cardDao: CardDao) {

     fun getCard():List<CardEntities> {
        return emptyList()
    }
}