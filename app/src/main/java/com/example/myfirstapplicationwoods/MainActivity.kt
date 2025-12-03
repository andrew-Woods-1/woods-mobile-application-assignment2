package com.example.myfirstapplicationwoods

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    companion object {
        private const val MSE_PERMISSION = "com.example.myfirstapplicationwoods.MSE412"
        private const val REQ_MSE_PERMISSION = 1001
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // XML layout

        // 1) Request the custom permission at runtime when the app starts
        if (ContextCompat.checkSelfPermission(this, MSE_PERMISSION)
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(MSE_PERMISSION),
                REQ_MSE_PERMISSION
            )
        }


        // Display name & ID
        val textView = findViewById<TextView>(R.id.textViewInfo)
        textView.text = "Andrew Woods\nStudent ID: 1356701"

        // Explicit Intnet Button
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

        val btnViewImageActivity = findViewById<Button>(R.id.btnViewImageActivity)
        btnViewImageActivity.setOnClickListener {
            val intent = Intent(this, ImageActivity::class.java)
            startActivity(intent)
        }

    }
}
