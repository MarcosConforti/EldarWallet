package com.example.eldarwallet.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eldarwallet.data.model.UserModel
import com.example.eldarwallet.domain.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val getUserUseCase: GetUserUseCase) : ViewModel() {

    private val _userLiveData = MutableLiveData<Boolean>()

    val userLiveData: LiveData<Boolean> = _userLiveData

    fun callUserUseCase(user: String, pass: String) {
        viewModelScope.launch {
            val result = getUserUseCase(UserModel(user, pass))
            delay(3000)
            _userLiveData.value = result
        }
    }
}