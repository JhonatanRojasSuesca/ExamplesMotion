package com.jhonatan.examplemotion

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FourActivity : AppCompatActivity() {
    private var finishTransition: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.four_animation_activity)

        val nextAnimation = this.findViewById<Button>(R.id.nextAnimation)
        nextAnimation.setOnClickListener {
            startActivity(Intent(this@FourActivity, ThreeActivity::class.java))
        }
        findViewById<FloatingActionButton>(R.id.floating).setOnClickListener {
            finishTransition = if (finishTransition) {
                findViewById<MotionLayout>(R.id.motionContainer).transitionToStart()
                false
            } else {
                findViewById<MotionLayout>(R.id.motionContainer).transitionToEnd()
                true
            }
        }
    }
}