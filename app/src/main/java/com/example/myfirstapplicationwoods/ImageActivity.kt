package com.example.myfirstapplicationwoods

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ImageActivity : AppCompatActivity() {

    private val CAMERA_REQUEST_CODE = 100

    private lateinit var btnCapture: Button
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        // Make absolutely sure we are using the right IDs
        btnCapture = findViewById(R.id.btnCaptureImage)
        imageView = findViewById(R.id.imageViewCaptured)

        // Quick test: change the title so we KNOW we are in ImageActivity
        title = "Image Activity"

        btnCapture.setOnClickListener {
            openCamera()
        }
    }

    private fun openCamera() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        // Only try to start if there is actually a camera app
        val canHandle = cameraIntent.resolveActivity(packageManager) != null

        if (canHandle) {
            startActivityForResult(cameraIntent, CAMERA_REQUEST_CODE)
        } else {
            Toast.makeText(this, "No camera app available", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == CAMERA_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            val extras = data.extras
            val imageBitmap = extras?.get("data") as? Bitmap
            if (imageBitmap != null) {
                imageView.setImageBitmap(imageBitmap)
            } else {
                Toast.makeText(this, "No image data returned", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
