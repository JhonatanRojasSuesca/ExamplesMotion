package com.jhonatan.examplemotion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.constraintlayout.motion.widget.MotionLayout

class ThreeActivity : AppCompatActivity() {

    lateinit var buttonNext: Button
    lateinit var buttonPrevious : Button
    lateinit var cards : MotionLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.three_animation_activity)


        buttonNext = findViewById(R.id.next)
        buttonPrevious = findViewById(R.id.previous)
        cards = findViewById(R.id.cards)

        buttonNext.setOnClickListener{
            starAnimationCard()
        }
        buttonPrevious.setOnClickListener{
            onBackAnimationCard()
        }
    }

    private fun onBackAnimationCard() {
        cards.transitionToStart()
        var isTransactionPreviousCard = true
        cards.doOnEnd {
            if (isTransactionPreviousCard) {
                cards.setTransition(R.id.medium_to_start)
                cards.transitionToEnd()
                isTransactionPreviousCard = false
            } else {
                cards.setTransition(R.id.init)
            }
        }
    }

    private fun starAnimationCard() {
        cards.transitionToEnd()
        var isTransactionNextCard = true
        cards.doOnEnd {
            if (isTransactionNextCard) {
                cards.setTransition(R.id.medium_to_end)
                cards.transitionToEnd()
                isTransactionNextCard = false
            }
        }
    }

    private fun MotionLayout.doOnEnd(onEnd: () -> Unit) {
        this.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {}
            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {}
            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {}
            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                onEnd()
            }
        })
    }
}