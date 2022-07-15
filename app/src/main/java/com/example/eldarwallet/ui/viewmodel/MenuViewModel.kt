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
class MenuViewModel @Inject constructor(private val getCardsUseCase: GetCardsUseCase) :
    ViewModel() {

    private val _cardsLiveData = MutableLiveData<List<CardModel>>()

    val cardsLiveData: LiveData<List<CardModel>> = _cardsLiveData

    init {
        callCardUseCase()
    }

    fun callCardUseCase() {
        viewModelScope.launch {
            val result = getCardsUseCase()
            if (result.isNotEmpty()) {
                _cardsLiveData.value = result
            }
        }
    }
}