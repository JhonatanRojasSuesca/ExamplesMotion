package com.jhonatan.examplemotion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_animation_activity)
        val nextAnimation = this.findViewById<Button>(R.id.nextAnimation)
        nextAnimation.setOnClickListener {
            startActivity(Intent(this@SecondActivity, FourActivity::class.java))
        }
    }
}