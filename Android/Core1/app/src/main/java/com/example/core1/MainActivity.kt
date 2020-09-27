package com.example.core1

import android.graphics.Color
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var health = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("Activity","onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1: Button = findViewById<Button>(R.id.sneeze)
        val button2: Button = findViewById<Button>(R.id.blowNose)
        val button3: Button = findViewById<Button>(R.id.takeMedi)

        button1.setOnClickListener {
            Log.i("Activity","button1 : onClick")
            health -= 1
            level()
        }

        button2.setOnClickListener {
            Log.i("Activity","button2 : onClick")
            var sound: MediaPlayer? = MediaPlayer.create(this, R.raw.alarm_clock)
            sound?.start()
        }

        button3.setOnClickListener {
            Log.i("Activity", "button2 : onClick")
            health += 2
            level()
        }

    }

    private fun level() {
        if(health > 10)
            health = 10
        if(health < 0)
            health = 0
        healthLevel.text = health.toString()
        when (health) {
            in 0..5 -> healthLevel.setBackgroundColor(Color.rgb(218, 38, 99))
            in 6..7 -> healthLevel.setBackgroundColor(Color.parseColor("#03A9F4"))
            in 8..10 -> healthLevel.setBackgroundColor(Color.rgb(255, 255, 255))
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("Activity", "onStart")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.i("Activity","onRestoreInstanceState")
        super.onRestoreInstanceState(savedInstanceState)
        health = savedInstanceState.getInt("Activity")
        Log.i("Activity", "onRestoreInstanceState $health")
        healthLevel.text = health.toString()
        level()
    }

    override fun onResume() {
        super.onResume()
        Log.i("Activity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Activity", "onPause")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("Activity", health)
        Log.i("Activity", "onSaveInstanceState")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Activity", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Activity", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Activity", "onDestroy")
    }





}