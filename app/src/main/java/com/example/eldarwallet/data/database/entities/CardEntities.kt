package com.example.eldarwallet.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CardEntities(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "card") val card: String,
    @ColumnInfo(name = "number") val number: Int,
    @ColumnInfo(name = "code") val code: Int,
    @ColumnInfo(name = "date") val date: String,
)
