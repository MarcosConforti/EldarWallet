package com.example.eldarwallet.data

import com.example.eldarwallet.data.model.User

class UserRepository {
    suspend fun validateUser(user: User): Boolean {
        if(user.user == "user" && user.pass == "123"){
            return true
        }
        return false
    }
}