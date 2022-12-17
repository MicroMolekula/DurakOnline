package com.developlstu.durakonline.models

import android.view.View
import com.developlstu.durakonline.views.CardsView

class Player(val id: Int, val heand: Array<CardsView?>) {
    fun initCards(deck: Deck){
        for(i in 0 until 6){
            heand[i]?.setValue(deck.takeCard())
        }
    }

    fun takeCards(deck: Deck){
        for(card in heand){
            if(card?.visibility == View.INVISIBLE){
                card.setValue(deck.takeCard())
                card.visibility = View.VISIBLE
            }
        }
    }

}