package com.example.eldarwallet.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eldarwallet.data.model.CardModel
import com.example.eldarwallet.domain.AddCardUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddCardViewModel @Inject constructor(private val addCardUseCase: AddCardUseCase) : ViewModel() {

    private val _addCardLiveData = MutableLiveData<Boolean>()

    val addCardLiveData: LiveData<Boolean> = _addCardLiveData

    fun addCard(cardName: String,cardNumber:String,cardCode: String, expireDate:String) {
        viewModelScope.launch {
            val result = addCardUseCase(CardModel(cardName, cardNumber, cardCode, expireDate))
            _addCardLiveData.value = result
        }
    }
}