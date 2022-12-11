package com.developlstu.durakonline

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val btnPlay = findViewById<ImageButton>(R.id.bntPlay)
        val btnSetings = findViewById<ImageButton>(R.id.btnSetings)
        val btnReg = findViewById<ImageButton>(R.id.btnReg)
        val btnExit = findViewById<ImageButton>(R.id.btnExit)

        btnExit.setOnClickListener(this::onBtnExit)
        btnPlay.setOnClickListener(this::onBtnPlay)
    }

    private fun onBtnExit(view: View){
        exitProcess(0)
    }

    private fun onBtnPlay(view: View){
        val intent: Intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }
}