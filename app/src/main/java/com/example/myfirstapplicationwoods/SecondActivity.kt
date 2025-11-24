package com.example.myfirstapplicationwoods

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second) // XML layout

        // Display 5 mobile software engineering challenges
        val textView = findViewById<TextView>(R.id.textViewChallenges)
        textView.text = """
            Mobile Software Engineering Challenges:
            1. Device fragmentation
            2. Limited battery life
            3. Performance optimization
            4. Security and privacy
            5. Network connectivity issues
        """.trimIndent()

        // Button to return to MainActivity
        val btnMain = findViewById<Button>(R.id.btnMain)
        btnMain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
