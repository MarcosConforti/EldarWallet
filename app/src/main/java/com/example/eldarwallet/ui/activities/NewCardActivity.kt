package com.example.eldarwallet.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import com.example.eldarwallet.R
import com.example.eldarwallet.databinding.ActivityNewCardBinding
import com.example.eldarwallet.ui.viewmodel.AddCardViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewCardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewCardBinding
    private val addCardViewModel: AddCardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewCardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etCardNumber.addTextChangedListener {
            if(it!=null && it.isNotEmpty()) {
                val cardName = when (it[0]) {
                    '3' -> "American Express"
                    '4' -> "Visa"
                    '5' -> "Master Card"
                    else -> {
                        "Tarjeta Desconocida"
                    }
                }
                binding.tvNombre.text = "Nueva Tarjeta $cardName"
            }
        }

        binding.btnAddCard.setOnClickListener {
            //hacer todo en una funcion bien piola
            val cardNumber = binding.etCardNumber.text.toString()
            val cardCode = binding.etCode.text.toString()
            val cardMonth = binding.etMonth.text.toString()
            val cardYear = binding.etYear.text.toString()
            val expireDate = "$cardMonth/$cardYear"
            val cardName = when(cardNumber.first()){
                '3'-> "American Express"
                '4'-> "Visa"
                '5'-> "Master Card"
                else -> {
                    "Tarjeta Desconocida"
                }
            }
            if (validateCard(cardNumber) && validateCodeCard(cardCode) && validateMonth(cardMonth)) {
                addCardViewModel.addCard(cardName,cardNumber, cardCode,expireDate)
            } else {
                showError(getText(R.string.cardError).toString())
            }

        }
        addCardViewModel.addCardLiveData.observe(this, Observer { isCardValid ->
            if (isCardValid) {
                //limpiar los campos y no volver
                goToMenu()
            } else {
                showError(getText(R.string.cardErrorTarjeta).toString())
            }
        })

    }

    private fun goToMenu() {
        val intent = Intent(this, MenuActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun showError(mensaje:String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
    }

    private fun validateCard(cardNumber: String): Boolean {

        return cardNumber.length == 16
    }

    //imputtype solo numeros
    private fun validateCodeCard(cardCode: String): Boolean {
        return cardCode.length in 3..4
    }

    private fun validateMonth(cardMonth: String): Boolean {
        return cardMonth.toInt() in 1..12
    }
}