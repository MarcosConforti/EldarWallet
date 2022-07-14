package com.example.eldarwallet.ui

import androidx.appcompat.app.AlertDialog
import com.example.eldarwallet.R

class LoadingDialog(private val loginActivity: LoginActivity) {
    private lateinit var isDialog:AlertDialog


    fun disMiss(){
        isDialog.dismiss()
    }
}