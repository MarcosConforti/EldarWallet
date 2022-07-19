package com.example.eldarwallet.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eldarwallet.R
import com.example.eldarwallet.data.model.CardModel
import com.example.eldarwallet.databinding.ActivityGeneratedPaymentBinding
import com.example.eldarwallet.ui.paymentRecycler.OnClickCardListener
import com.example.eldarwallet.ui.paymentRecycler.PaymentAdapter
import com.example.eldarwallet.ui.viewmodel.PaymentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GeneratedPayment : AppCompatActivity(), OnClickCardListener {

    private lateinit var binding: ActivityGeneratedPaymentBinding
    private var adapter = PaymentAdapter(emptyList(), this)
    private val paymentViewModel: PaymentViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGeneratedPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvCards.layoutManager = LinearLayoutManager(this)
        binding.rvCards.adapter = adapter


        paymentViewModel.paymentLiveData.observe(this, Observer { cardList ->
            adapter.setCardList(cardList)

        })

        binding.btnGeneratePayment.setOnClickListener {
            generatedTransaction()
        }

    }

    override fun onCardClicked(card: CardModel) {
        generatedTransaction()
    }

    private fun generatedTransaction() {
        Toast.makeText(this, getText(R.string.succesful), Toast.LENGTH_SHORT).show()

    }


}