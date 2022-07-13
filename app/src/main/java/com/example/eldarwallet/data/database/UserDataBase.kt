package com.example.eldarwallet.data.database

import androidx.room.Database
import com.example.eldarwallet.data.database.dao.UserDao
import com.example.eldarwallet.data.database.entities.UserEntities

@Database (entities = [UserEntities::class], version = 1)
abstract class UserDataBase {
    abstract fun getUserDao():UserDao
}