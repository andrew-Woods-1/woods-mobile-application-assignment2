package com.example.myfirstapplicationwoods

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // XML layout

        // Display name & ID
        val textView = findViewById<TextView>(R.id.textViewInfo)
        textView.text = "Andrew Woods\nStudent ID: 1356701"

        // Explicit Intent Button
        val btnExplicit = findViewById<Button>(R.id.btnExplicit)
        btnExplicit.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        // Implicit Intent Button
        val btnImplicit = findViewById<Button>(R.id.btnImplicit)
        btnImplicit.setOnClickListener {
            val intent = Intent("com.example.myfirstapplicationwoods.SECOND_ACTIVITY")
            startActivity(intent)
        }
    }
}
