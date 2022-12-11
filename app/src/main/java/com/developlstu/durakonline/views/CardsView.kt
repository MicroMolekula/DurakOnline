package com.developlstu.durakonline.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import com.developlstu.durakonline.R
import com.developlstu.durakonline.constants.Suit
import com.developlstu.durakonline.constants.cardValue
import com.developlstu.durakonline.models.Cards
import com.developlstu.durakonline.models.Deck


class CardsView : View {
    private val paint = Paint()
    val cardValue: Map<String, Int> = cardValue()
    private var value: Cards? = null
    private var widthCard: Int = 100
    private var heightCard: Int = 200

    companion object{
        var tmpCard: Cards? = null
    }

    constructor(ctx: Context, atts: AttributeSet):
        super(ctx, atts)


    constructor(ctx: Context, atts: AttributeSet, defStyle: Int):
        super(ctx, atts, defStyle)

    fun setValue(card: Cards){
        value = card
    }

    fun getValue() = value

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        widthCard = w
        heightCard = h
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.apply {
            style = Paint.Style.FILL
            color = Color.WHITE
        }
        canvas?.drawPaint(paint)
        if (value != null) {
            paint.apply {
                color =
                    if (Suit.CLUBS == value?.suit || Suit.SPADES == value?.suit) Color.BLACK else Color.RED
                style = Paint.Style.FILL
                isAntiAlias = true
                textSize = Math.min(widthCard, heightCard) * 10 / (25F)
            }
            canvas?.drawText(
                "${value!!.value}${value!!.suit.suit}",
                (widthCard / 130F) * 10,
                (heightCard / 50F) * 10,
                paint
            )
            canvas?.drawText(
                "${value!!.value}${value!!.suit.suit}",
                (widthCard / 130F) * 10,
                heightCard.toFloat() - 20F,
                paint
            )

        } else if (this.id != R.id.deck) {
            paint.apply {
                color = Color.BLACK
                style = Paint.Style.FILL
                isAntiAlias = true
                textSize = Math.min(widthCard, heightCard) * 10 / (25F)
            }
            canvas?.drawText("?", widthCard / 2F - 10F, heightCard / 2F, paint)
        } else if (this.id == R.id.deck) {
            paint.apply {
                color = Color.BLACK
                style = Paint.Style.FILL
                isAntiAlias = true
                textSize = Math.min(widthCard, heightCard) * 10 / (25F)
            }
            canvas?.drawText("${Deck.Companion.size}", widthCard / 2F - 20F, heightCard / 2F, paint)
        }
    }

}