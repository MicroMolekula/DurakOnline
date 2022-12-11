package com.developlstu.durakonline.constants

enum class Suit(val suit: String){
    SPADES("♠"), HEARTS("♥"), DIAMS("♦"), CLUBS("♣")
}

fun cardValue(): Map<String, Int> =
    mapOf("6" to 0, "7" to 1, "8" to 2, "9" to 3, "10" to 4, "J" to 5, "D" to 6, "K" to 7, "A" to 8)