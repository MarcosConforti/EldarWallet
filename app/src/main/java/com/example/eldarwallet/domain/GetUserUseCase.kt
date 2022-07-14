package com.example.eldarwallet.domain

import com.example.eldarwallet.data.UserRepository
import com.example.eldarwallet.data.model.User
import javax.inject.Inject

class GetUserUseCase @Inject constructor(private val userRepository: UserRepository) {

    suspend operator fun invoke(user: User): Boolean {
        return userRepository.validateUser(user)
    }
}