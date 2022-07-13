package com.example.eldarwallet.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

class UserEntities (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "user") val user: String,
    @ColumnInfo(name = "pass") val pass: Int
    )