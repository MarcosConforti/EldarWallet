package com.example.eldarwallet.ui.paymentRecycler

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.eldarwallet.data.model.CardModel
import com.example.eldarwallet.databinding.CardListBinding

class PaymentViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = CardListBinding.bind(view)

    @SuppressLint("SetTextI18n")
    fun render(cards: CardModel){
        binding.tvCardName.text = cards.cardName + " terminada en " +
                cards.cardNumber.substring( 12)

    }
}