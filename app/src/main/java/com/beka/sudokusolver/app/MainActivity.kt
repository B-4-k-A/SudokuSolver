package com.beka.sudokusolver.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.solve_puzzle_button).setOnClickListener {
            Toast.makeText(
                this, "Button pressed", Toast.LENGTH_LONG
            ).show()
        }
    }

}