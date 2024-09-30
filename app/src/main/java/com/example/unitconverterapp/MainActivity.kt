package com.example.unitconverterapp

import android.os.Bundle
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button



class MainActivity : AppCompatActivity() {

    private lateinit var temperatureButton: Button
    private lateinit var lengthButton: Button
    private lateinit var weightButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the content view to the main activity layout
        setContentView(R.layout.activity_main)

        // Initialize buttons
        temperatureButton = findViewById(R.id.temperatureButton)
        lengthButton = findViewById(R.id.lengthButton)
        weightButton = findViewById(R.id.weightButton)

        // Set click listeners
        temperatureButton.setOnClickListener {
            val intent = Intent(this, ConversionActivity::class.java)
            intent.putExtra("conversionType", "Temperature")
            startActivity(intent)
        }

        lengthButton.setOnClickListener {
            val intent = Intent(this, ConversionActivity::class.java)
            intent.putExtra("conversionType", "Length")
            startActivity(intent)
        }

        weightButton.setOnClickListener {
            val intent = Intent(this, ConversionActivity::class.java)
            intent.putExtra("conversionType", "Weight")
            startActivity(intent)
        }
    }
}