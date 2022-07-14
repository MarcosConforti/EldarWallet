package com.example.eldarwallet.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eldarwallet.data.database.entities.CardEntities
import com.example.eldarwallet.domain.GetCardUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardViewModel @Inject constructor(private val getCardUseCase: GetCardUseCase):ViewModel()  {

    private val _cardLiveData = MutableLiveData<List<CardEntities>>()

    val cardLiveData:LiveData<List<CardEntities>> = _cardLiveData

    fun callCardUseCase(){
        viewModelScope.launch {
            val result = getCardUseCase()
            if (result.isNotEmpty()){
                _cardLiveData.value = result
            }
        }
    }
}