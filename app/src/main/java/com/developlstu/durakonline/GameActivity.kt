package com.developlstu.durakonline

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.View.*
import android.widget.Button
import android.widget.LinearLayout
import com.developlstu.durakonline.views.CardsView
import com.developlstu.durakonline.constants.Suit
import com.developlstu.durakonline.constants.cardValue
import com.developlstu.durakonline.models.Cards
import com.developlstu.durakonline.models.Deck
import com.developlstu.durakonline.models.GameModel
import kotlin.random.Random

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        supportActionBar?.hide()
        val deck = Deck()

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

        val cardsOnField: Array<CardsView?> = Array(6, {null})
        cardsOnField[0] = findViewById(R.id.cardonfield1)
        cardsOnField[1] = findViewById(R.id.cardonfield2)
        cardsOnField[2] = findViewById(R.id.cardonfield3)
        cardsOnField[3] = findViewById(R.id.cardonfield4)
        cardsOnField[4] = findViewById(R.id.cardonfield5)
        cardsOnField[5] = findViewById(R.id.cardonfield6)

        val cardsOnFieldEnemy: Array<CardsView?> = Array(6, {null})
        cardsOnFieldEnemy[0] = findViewById(R.id.cardonfieldenemy1)
        cardsOnFieldEnemy[1] = findViewById(R.id.cardonfieldenemy2)
        cardsOnFieldEnemy[2] = findViewById(R.id.cardonfieldenemy3)
        cardsOnFieldEnemy[3] = findViewById(R.id.cardonfieldenemy4)
        cardsOnFieldEnemy[4] = findViewById(R.id.cardonfieldenemy5)
        cardsOnFieldEnemy[5] = findViewById(R.id.cardonfieldenemy6)

        val deckView: CardsView = findViewById(R.id.deck)
        val trump: CardsView = findViewById(R.id.trump)
        val btnBito: Button = findViewById(R.id.btnbito)

        val gameModel = GameModel(
            cardsPlayer,
            cardsEnemy,
            cardsOnField,
            cardsOnFieldEnemy,
            deck,
            trump
        )
        gameModel.play()

    }

}
