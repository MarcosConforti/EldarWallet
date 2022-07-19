package com.example.eldarwallet.ui.paymentRecycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.eldarwallet.R
import com.example.eldarwallet.data.model.CardModel

class PaymentAdapter(
    private var cardList: List<CardModel>,
    private var onClickCardListener: OnClickCardListener?
) : RecyclerView.Adapter<PaymentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PaymentViewHolder(layoutInflater.inflate(R.layout.card_list, parent, false))
    }

    override fun onBindViewHolder(holder: PaymentViewHolder, position: Int) {
        val item = cardList[position]
        holder.render(item)
        holder.itemView.setOnClickListener { onClickCardListener?.onCardClicked(item) }
    }

    override fun getItemCount(): Int = cardList.size

    fun setCardList(newCardList: List<CardModel>) {
        cardList = newCardList
        notifyDataSetChanged()
    }
}