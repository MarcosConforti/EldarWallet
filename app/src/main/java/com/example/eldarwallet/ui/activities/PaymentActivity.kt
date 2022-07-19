package com.example.eldarwallet.ui.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.eldarwallet.R
import com.example.eldarwallet.databinding.ActivityPaymentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PaymentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPaymentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnConfirmPayment.setOnClickListener {
          setMessage()
        }
    }

    private fun setMessage() {
        Toast.makeText(this,getText(R.string.succesful),Toast.LENGTH_SHORT).show()
    }
}