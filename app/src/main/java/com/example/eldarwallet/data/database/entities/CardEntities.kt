package com.example.eldarwallet.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CardEntities(
    @PrimaryKey @ColumnInfo(name = "number") val number: String,
    @ColumnInfo(name = "card") val card: String,
    @ColumnInfo(name = "code") val code: String,
    @ColumnInfo(name = "date") val date: String,
)
