package com.example.eldarwallet.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.eldarwallet.data.database.entities.CardEntities

@Dao
interface CardDao {
    @Query("SELECT * FROM card_table")
    suspend fun getAllDrinks():List<CardEntities>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(card:List<CardEntities>)

    @Query("DELETE FROM card_table")
    suspend fun deleteAllCards()
}