package com.example.eldarwallet.ui.viewmodel

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eldarwallet.domain.GetQRUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QrViewModel @Inject constructor(private val getQRUseCase: GetQRUseCase) : ViewModel() {

    private val _getQrLiveData = MutableLiveData<Bitmap?>()

    val getQRLiveData: LiveData<Bitmap?> = _getQrLiveData

    fun callGetQRUseCase(content: String) {
        viewModelScope.launch {
            val result = getQRUseCase.invoke(content)
            _getQrLiveData.value = result
        }

    }
}