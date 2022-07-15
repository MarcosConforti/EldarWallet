package com.example.eldarwallet.ui.cardRecycler

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.eldarwallet.data.model.CardModel
import com.example.eldarwallet.databinding.CardListBinding

class CardViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = CardListBinding.bind(view)

    @SuppressLint("SetTextI18n")
    fun render(cards: CardModel){
        binding.tvCardName.text = cards.cardName + " terminada en " +
                cards.cardNumber.substring( 12)

    }
}