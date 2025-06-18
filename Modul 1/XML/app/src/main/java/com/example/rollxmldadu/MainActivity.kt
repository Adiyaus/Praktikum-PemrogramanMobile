package com.example.rollxmldadu

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.rollxmldadu.databinding.ActivityMainBinding
import kotlin.random.Random


class
MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val diceImages = listOf(
        R.drawable.dice_0,
        R.drawable.dice_1,
        R.drawable.dice_2,
        R.drawable.dice_3,
        R.drawable.dice_4,
        R.drawable.dice_5,
        R.drawable.dice_6
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rollButton.setOnClickListener {
            val dice1 = Random.nextInt(6)
            val dice2 = Random.nextInt(6)

            binding.diceImage1.setImageResource(diceImages[dice1])
            binding.diceImage2.setImageResource(diceImages[dice2])

            val message = if (dice1 == dice2) {
                "Selamat, anda dapat dadu double!"
            } else {
                "Anda belum beruntung!"
            }

            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }
}
