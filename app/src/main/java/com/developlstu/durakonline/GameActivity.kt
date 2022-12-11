package com.developlstu.durakonline

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import com.developlstu.durakonline.views.CardsView
import com.developlstu.durakonline.constants.Suit
import com.developlstu.durakonline.constants.cardValue
import com.developlstu.durakonline.models.Cards
import com.developlstu.durakonline.models.Deck
import kotlin.random.Random

class GameActivity : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        supportActionBar?.hide()
        val deck: Deck = Deck()
        deck.outputDeck()



        val cardsEnemy: Array<CardsView?> = Array(6, {null})
        cardsEnemy[0] = findViewById(R.id.enemyCard1)
        cardsEnemy[1] = findViewById(R.id.enemyCard2)
        cardsEnemy[2] = findViewById(R.id.enemyCard3)
        cardsEnemy[3] = findViewById(R.id.enemyCard4)
        cardsEnemy[4] = findViewById(R.id.enemyCard5)
        cardsEnemy[5] = findViewById(R.id.enemyCard6)

        val cardsPlayer: Array<CardsView?> = Array(6, {null})
        cardsPlayer[0] = findViewById(R.id.card1)
        cardsPlayer[1] = findViewById(R.id.card2)
        cardsPlayer[2] = findViewById(R.id.card3)
        cardsPlayer[3] = findViewById(R.id.card4)
        cardsPlayer[4] = findViewById(R.id.card5)
        cardsPlayer[5] = findViewById(R.id.card6)
        initCardsPlayer(cardsPlayer, deck)

        val deckView: CardsView = findViewById(R.id.deck)
        val trump: CardsView = findViewById(R.id.trump)
        trump.setValue(deck.takeTrump())


        cardsPlayer[0]?.setOnTouchListener(this::hideCard)
        cardsPlayer[1]?.setOnTouchListener(this::hideCard)
        cardsPlayer[2]?.setOnTouchListener(this::hideCard)
        cardsPlayer[3]?.setOnTouchListener(this::hideCard)
        cardsPlayer[4]?.setOnTouchListener(this::hideCard)
        cardsPlayer[5]?.setOnTouchListener(this::hideCard)

    }

    private fun initCardsPlayer(array: Array<CardsView?>, deck: Deck){
        for(i in 0 until 6){
            array[i]?.setValue(deck.takeCard())
        }
    }

    private fun hideCard(view: View, event: MotionEvent): Boolean{
        view.visibility = View.INVISIBLE
        return true
    }
}













