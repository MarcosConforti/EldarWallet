package com.example.eldarwallet.ui.cardRecycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.eldarwallet.R
import com.example.eldarwallet.data.model.CardModel

class CardAdapter(private var cardList:List<CardModel>)
    : RecyclerView.Adapter<CardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CardViewHolder(layoutInflater.inflate(R.layout.card_list,parent,false))
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val item = cardList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = cardList.size

    //funcion para actualizar la lista
    fun setCardList(newCardList: List<CardModel>) {
        cardList = newCardList
        notifyDataSetChanged()
    }
}