package com.example.eldarwallet.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eldarwallet.data.model.CardModel
import com.example.eldarwallet.domain.GetCardsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PaymentViewModel @Inject constructor(private val getCardsUseCase: GetCardsUseCase) :
    ViewModel() {

    private val _paymentLiveData = MutableLiveData<List<CardModel>>()

    val paymentLiveData: LiveData<List<CardModel>> = _paymentLiveData

    init {
        callCardUseCase()
    }

    private fun callCardUseCase() {
        viewModelScope.launch {
            val result = getCardsUseCase()
            if (result.isNotEmpty()) {
                _paymentLiveData.value = result
            }
        }
    }
}