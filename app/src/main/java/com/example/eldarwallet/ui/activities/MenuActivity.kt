package com.example.eldarwallet.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eldarwallet.databinding.ActivityMenuBinding
import com.example.eldarwallet.ui.cardRecycler.CardAdapter
import com.example.eldarwallet.ui.viewmodel.MenuViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding
    private var adapter = CardAdapter(emptyList())
    private val menuViewModel: MenuViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvCards.layoutManager = LinearLayoutManager(this)
        binding.rvCards.adapter = adapter

        menuViewModel.cardsLiveData.observe(this, Observer { cardList ->

            adapter.setCardList(cardList)
        })
        binding.btnAddNewCard.setOnClickListener {
            newCard()
        }
        binding.btnGeneratePayment.setOnClickListener {
            generatedPayment()
        }
        binding.btnQr.setOnClickListener {
            getQR()
        }
    }

    private fun newCard() {
        val intent = Intent(this, NewCardActivity::class.java)
        startActivity(intent)
    }

   private fun getQR() {

        val intent = Intent(this, QrActivity::class.java)
        startActivity(intent)
    }

    private fun generatedPayment() {
        val intent = Intent(this, GeneratedPayment::class.java)
        startActivity(intent)
    }

}