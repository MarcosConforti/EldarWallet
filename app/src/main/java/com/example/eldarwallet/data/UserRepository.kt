package com.example.eldarwallet.data

import com.example.eldarwallet.data.model.UserModel
import javax.inject.Inject

class UserRepository @Inject constructor() {
    suspend fun validateUser(userModel: UserModel): Boolean {
        if(userModel.user == "user" && userModel.pass == "123"){
            return true
        }
        return false
    }
}