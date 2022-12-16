package com.developlstu.durakonline.models

import android.media.AsyncPlayer
import android.view.View
import com.developlstu.durakonline.GameActivity
import com.developlstu.durakonline.views.CardsView
import com.developlstu.durakonline.models.Cards
import com.developlstu.durakonline.models.Deck
import java.lang.Math.abs
import kotlin.random.Random
import com.developlstu.durakonline.constants.cardValue


class GameModel(val cardsPlayer: Array<CardsView?>,
                val cardsEnemy: Array<CardsView?>,
                val cardsOnField: Array<CardsView?>,
                val cardsOnFieldEnemy: Array<CardsView?>,
                val deck: Deck,
                val trump: CardsView){

    val cValue = cardValue()


    public fun play(){
        initCardsPlayer(cardsPlayer, deck)
        initCardsOnField(cardsOnField)
        initCardsEnemy(cardsEnemy, deck)
        initCardsOnField(cardsOnFieldEnemy)
        trump.setValue(deck.takeTrump())
        var turn = 1
        for (i in cardsPlayer) i?.setOnClickListener(MoveCard(i.getValue(), cardsOnField))
        for (i in cardsEnemy) i?.setOnClickListener(MoveCard(i.getValue(), cardsOnFieldEnemy))
        //turn = abs(turn - 1)

    }

    private fun initCardsPlayer(array: Array<CardsView?>, deck: Deck){
        for(i in 0 until 6){
            array[i]?.setValue(deck.takeCard())
        }
    }

    private fun initCardsOnField(array: Array<CardsView?>){
        for(i in 0 until 6){
            array[i]?.visibility = View.INVISIBLE
        }
    }

    private fun initCardsEnemy(array: Array<CardsView?>, deck: Deck){
        for(i in 0 until 6){
            array[i]?.setValue(deck.takeCard())
        }
    }

    private fun countCards(): Boolean {
        if(Deck.Companion.size == 0 && trump.visibility == View.INVISIBLE){
            var count = 0
            for(i in cardsEnemy) if(i?.visibility == View.INVISIBLE) count++
            if(count == 6) return false
            count = 0
            for(j in cardsPlayer) if(j?.visibility == View.INVISIBLE) count++
            if(count == 6) return false
        }
        return true
    }

    class MoveCard(val card: Cards?, val array: Array<CardsView?>): View.OnClickListener{
        override fun onClick(v: View){
            CardsView.Companion.tmpCard = card
            v.visibility = View.INVISIBLE
            this.moveCardOnField(array)
        }

        private fun moveCardOnField(arrayField: Array<CardsView?>){
            for(i in arrayField){
                if(i?.visibility != View.VISIBLE){
                    i?.setValue(CardsView.Companion.tmpCard!!)
                    i?.visibility = View.VISIBLE
                    break
                }
            }
        }
    }
}
