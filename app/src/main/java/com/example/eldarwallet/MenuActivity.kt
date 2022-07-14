package com.example.eldarwallet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.eldarwallet.databinding.ActivityMenuBinding
import com.example.eldarwallet.ui.viewmodel.UserViewModel

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding
    private val userViewModel:UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //userViewModel.callUserUseCase()

        //userViewModel.userLiveData.observe(this, Observer { it })

       /* newCard()
        getQR()
        generatedPayment()*/
    }

   /* private fun newCard(){
        val intent = Intent(this,NewCardActivity::class.java)
    }
    private fun getQR(){
        val intent = Intent(this,GetQRActivity::class.java)
    }
    private fun generatedPayment(){
        val intent = Intent(this,GeneratedPaymentActivity::class.java)
    }*/
}