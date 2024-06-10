package com.example.project2

class BlackJack {
    private val cards = mutableListOf<Int>()
    private val cardValues = (2..13).toList()

    fun resetGame() {
        cards.clear()
    }

    fun dealCard(): Int {
        val card = cardValues.random()
        cards.add(card)
        return card
    }

    fun getCurrentTotal(): Int {
        return cards.sum()
    }

    fun getStatus(): String {
        val total = getCurrentTotal()
        return when {
            total > 21 -> "LOST"
            total in 17..21 -> "WON"
            else -> "PLAY"
        }
    }

    fun getCardsDealt(): List<Int> {
        return cards
    }
}
