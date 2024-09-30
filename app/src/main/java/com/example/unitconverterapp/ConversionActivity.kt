package com.example.unitconverterapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ConversionActivity : AppCompatActivity() {
    private lateinit var conversionType: String
    private lateinit var spinner: Spinner
    private lateinit var inputValue: EditText
    private lateinit var convertButton: Button
    private lateinit var resultView: TextView
    private lateinit var backButton: Button
    private lateinit var conversionOptions: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the content view to the conversion activity layout
        setContentView(R.layout.conversion_activity)

        // Initialize the back button
        backButton = findViewById(R.id.backButton)

        // Set click listener
        backButton.setOnClickListener {
            /* Return to MainActivity */
            finish()
        }

        // Get the conversion type from the intent
        conversionType = intent.getStringExtra("conversionType") ?: "Temperature"

        // Initialize UI components
        spinner = findViewById(R.id.conversionSpinner)
        inputValue = findViewById(R.id.inputValue)
        convertButton = findViewById(R.id.convertButton)
        resultView = findViewById(R.id.resultView)

        // Set up the spinner options based on the conversion type
        conversionOptions = when (conversionType) {
            "Temperature" -> arrayOf("Celsius to Fahrenheit", "Fahrenheit to Celsius")
            "Length" -> arrayOf("Meters to Feet", "Feet to Meters")
            "Weight" -> arrayOf("Kilograms to Pounds", "Pounds to Kilograms")
            else -> arrayOf()
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, conversionOptions)
        spinner.adapter = adapter

        // Set up the convert button click listener
        convertButton.setOnClickListener {
            val selectedConversion = spinner.selectedItem.toString()
            val value = inputValue.text.toString().toDoubleOrNull()

            if (value != null) {
                val result = performConversion(selectedConversion, value)
                resultView.text = "Result: $result"
            } else {
                Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun performConversion(conversion: String, value: Double): Double {
        return when (conversion) {
            "Celsius to Fahrenheit" -> celsiusToFahrenheit(value)
            "Fahrenheit to Celsius" -> fahrenheitToCelsius(value)
            "Meters to Feet" -> metersToFeet(value)
            "Feet to Meters" -> feetToMeters(value)
            "Kilograms to Pounds" -> kilogramsToPounds(value)
            "Pounds to Kilograms" -> poundsToKilograms(value)
            else -> 0.0
        }
    }

    // Conversion functions
    private fun celsiusToFahrenheit(celsius: Double): Double = celsius * 9 / 5 + 32
    private fun fahrenheitToCelsius(fahrenheit: Double): Double = (fahrenheit - 32) * 5 / 9
    private fun metersToFeet(meters: Double): Double = meters * 3.28084
    private fun feetToMeters(feet: Double): Double = feet / 3.28084
    private fun kilogramsToPounds(kg: Double): Double = kg * 2.20462
    private fun poundsToKilograms(lb: Double): Double = lb / 2.20462
}