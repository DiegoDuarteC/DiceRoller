package com.diegoduarte.diceroller

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.diegoduarte.diceroller.models.Dice

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var diceImage: ImageView = findViewById(R.id.imgDice)
        val rollButton: Button = findViewById(R.id.btnRollDice)

        var animation: AnimationDrawable

        val dice = Dice(6)

        rollButton.setOnClickListener {

            //Build dice roll animation based on roll outcome
            animation = buildRollAnimation(dice.roll())

            //set the animation on the ImageView
            diceImage.setImageDrawable(animation)

            //remove the previous animation before running the updated one
            if (animation.isRunning) {
                animation.stop()
            }

            animation.start()

        }

    }

    //Add frames to the animation. Last frame is always the roll outcome
    private fun buildRollAnimation(roll: Int) : AnimationDrawable{
        val animationDrawable = AnimationDrawable()

        println(roll)

        //run animation once only
        animationDrawable.isOneShot = true

        animationDrawable.addFrame(ContextCompat.getDrawable(this, R.drawable.dice_4)!!, 200)
        animationDrawable.addFrame(ContextCompat.getDrawable(this, R.drawable.dice_2)!!, 200)
        animationDrawable.addFrame(ContextCompat.getDrawable(this, R.drawable.dice_6)!!, 200)
        animationDrawable.addFrame(ContextCompat.getDrawable(this, R.drawable.dice_1)!!, 200)
        animationDrawable.addFrame(ContextCompat.getDrawable(this, R.drawable.dice_3)!!, 200)

        when(roll) {
            1 -> animationDrawable.addFrame(ContextCompat.getDrawable(this, R.drawable.dice_1)!!, 200)
            2 -> animationDrawable.addFrame(ContextCompat.getDrawable(this, R.drawable.dice_2)!!, 200)
            3 -> animationDrawable.addFrame(ContextCompat.getDrawable(this, R.drawable.dice_3)!!, 200)
            4 -> animationDrawable.addFrame(ContextCompat.getDrawable(this, R.drawable.dice_4)!!, 200)
            5 -> animationDrawable.addFrame(ContextCompat.getDrawable(this, R.drawable.dice_5)!!, 200)
            6 -> animationDrawable.addFrame(ContextCompat.getDrawable(this, R.drawable.dice_6)!!, 200)
        }

        return animationDrawable

    }

}