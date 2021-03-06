package com.example.eldarwallet.domain

import com.example.eldarwallet.data.UserRepository
import com.example.eldarwallet.data.model.UserModel
import javax.inject.Inject

class GetUserUseCase @Inject constructor(private val userRepository: UserRepository) {

    suspend operator fun invoke(userModel: UserModel): Boolean {
        return userRepository.validateUser(userModel)
    }
}