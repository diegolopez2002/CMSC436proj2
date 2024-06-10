package com.example.project2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var statusTextView: TextView
    private lateinit var totalTextView: TextView
    private lateinit var dealButton: Button
    private lateinit var cardButtons: List<Button>
    private val blackJack = BlackJack()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        statusTextView = findViewById(R.id.statusTextView)
        totalTextView = findViewById(R.id.totalTextView)
        dealButton = findViewById(R.id.dealButton)
        cardButtons = listOf(
            findViewById(R.id.cardButton1),
            findViewById(R.id.cardButton2),
            findViewById(R.id.cardButton3),
            findViewById(R.id.cardButton4)
        )

        dealButton.setOnClickListener {
            if (statusTextView.text == "PLAY") {
                dealCards()
                updateUI()
            }
        }
        resetGame()
    }

    private fun dealCards() {
        val cardsDealt = blackJack.getCardsDealt().size
        if (cardsDealt < 4) {
            blackJack.dealCard()
        }
    }

    private fun updateUI() {
        val cards = blackJack.getCardsDealt()
        for (i in cards.indices) {
            cardButtons[i].text = cards[i].toString()
        }
        totalTextView.text = blackJack.getCurrentTotal().toString()
        statusTextView.text = blackJack.getStatus()
    }

    @SuppressLint("SetTextI18n")
    private fun resetGame() {
        blackJack.resetGame()
        for (button in cardButtons) {
            button.text = "0"
        }
        totalTextView.text = "0"
        statusTextView.text = "PLAY"
    }
}
