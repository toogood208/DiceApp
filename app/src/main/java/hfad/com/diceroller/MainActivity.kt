package hfad.com.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

/**
 *this activity allows the user to roll a dice and display it on the scree
 *
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // grab the button
        val rollButoon: Button = findViewById(R.id.button)
        //when the button is clicked roll dice
        rollButoon.setOnClickListener { rollDice() }

        // roll dice when app start
        rollDice()
    }

    /**
     * Rools the dice and update the screen with the result
     */
    private fun rollDice() {
        // create a dice object and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // grab the image
        val diceImage : ImageView = findViewById(R.id.imageView)
        // determine the image to show depending on dice roll
        val drawableResource = when(diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // set the image to the screen
        diceImage.setImageResource(drawableResource)
        //set content description
        diceImage.contentDescription = diceRoll.toString()
    }
}

/**
 *  the dice roll logic
 */
class Dice(private val numberOfSides: Int) {

    fun roll(): Int {
        return (1..numberOfSides).random()
    }
}