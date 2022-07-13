package com.example.eldarwallet.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.eldarwallet.data.database.dao.CardDao
import com.example.eldarwallet.data.database.entities.CardEntities

@Database (entities = [CardEntities::class], version = 1)
abstract class CardDataBase:RoomDatabase() {
    abstract fun getCardDao(): CardDao
}