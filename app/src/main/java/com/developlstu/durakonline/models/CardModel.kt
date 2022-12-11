package com.developlstu.durakonline.models

import com.developlstu.durakonline.constants.Suit
import com.developlstu.durakonline.constants.cardValue
import kotlin.random.Random

val valuesCard = cardValue()


fun output(card: Cards){
    println("${card.suit} ${card.value}")
}

data class Cards(val suit: Suit, val value: String)


class Deck(){

    companion object{
        var size = 36
    }
    private val deck: ArrayList<Cards> = ArrayList()
    init{
        for(i in Suit.values()){
            for(j in valuesCard.keys.toTypedArray()){
                deck.add(Cards(i, j))
            }
        }
    }

    fun outputDeck(){
        for(i in deck) output(i)
    }

    fun getContent(): ArrayList<Cards> = deck

    fun takeCard(): Cards{
        val rs = Random.nextInt(size-1)
        val tmp = deck[rs]
        size--
        deck.removeAt(rs)
        return tmp
    }

    fun takeTrump(): Cards{
        return deck[Random.nextInt(size-1)]
    }
}