package com.example.eldarwallet.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.eldarwallet.data.database.entities.CardEntities
import com.example.eldarwallet.data.model.CardModel

@Dao
interface CardDao {
    @Query("SELECT * FROM CardEntities")
    suspend fun getAllCards(): List<CardEntities>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(card: List<CardEntities>)

    @Insert
    suspend fun insert(card: CardEntities)

    @Query("DELETE FROM CardEntities")
    suspend fun deleteAllCards()
}