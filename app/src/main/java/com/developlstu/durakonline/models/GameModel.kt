package com.developlstu.durakonline.models

import android.media.AsyncPlayer
import android.view.View
import android.widget.Button
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
                val trump: CardsView,
                val btn: Button){

    val cValue = cardValue()
    val p1 = Player(1, cardsPlayer)
    val p2 = Player(2, cardsEnemy)
    companion object{
        var turn:Boolean = true
    }

    fun play(){
        p1.initCards(deck)
        p2.initCards(deck)
        initCardsOnField(cardsOnField)
        initCardsOnField(cardsOnFieldEnemy)
        trump.setValue(deck.takeTrump())
        atack(p1)
        defend(p2)
    }

    private fun initCardsOnField(array: Array<CardsView?>){
        for(i in 0 until 6){
            array[i]?.visibility = View.INVISIBLE
        }
    }

    private fun countCardInHand(arr: Array<CardsView?>): Int{
        var count: Int = 0
        for(card in arr){
            if(card?.visibility == View.VISIBLE){
                count++
            }
        }
        return count
    }

    private fun winner(): Int{
        if(Deck.Companion.size == 0 && trump.visibility == View.INVISIBLE){
            if(countCardInHand(p1.heand) == 0){
                return p1.id
            }
            else if(countCardInHand(p2.heand) == 0){
                return p2.id
            }
        }
        return 0
    }

    private fun atack(p: Player){
        for (card in p.heand) card?.setOnClickListener(MoveCard(card.getValue(), cardsOnFieldEnemy))
    }

    private fun defend(p: Player){
        for (card in p.heand) card?. setOnClickListener(MoveCard(card.getValue(), cardsOnField))
    }

    private fun nextTurn(view: View){
        if(turn) { turn = false}
        else {turn = true}
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
