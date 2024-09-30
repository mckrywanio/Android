package com.example.unitconverterapp

import org.junit.Assert.assertEquals
import org.junit.Test

class ConversionUnitTest {

    @Test
    fun testCelsiusToFahrenheit() {
        val input = 0.0
        val expected = 32.0
        val actual = celsiusToFahrenheit(input)
        assertEquals(expected, actual, 0.001)
    }

    @Test
    fun testFahrenheitToCelsius() {
        val input = 32.0
        val expected = 0.0
        val actual = fahrenheitToCelsius(input)
        assertEquals(expected, actual, 0.001)
    }

    @Test
    fun testMetersToFeet() {
        val input = 1.0
        val expected = 3.28084
        val actual = metersToFeet(input)
        assertEquals(expected, actual, 0.00001)
    }

    @Test
    fun testFeetToMeters() {
        val input = 3.28084
        val expected = 1.0
        val actual = feetToMeters(input)
        assertEquals(expected, actual, 0.00001)
    }

    @Test
    fun testKilogramsToPounds() {
        val input = 1.0
        val expected = 2.20462
        val actual = kilogramsToPounds(input)
        assertEquals(expected, actual, 0.00001)
    }

    @Test
    fun testPoundsToKilograms() {
        val input = 2.20462
        val expected = 1.0
        val actual = poundsToKilograms(input)
        assertEquals(expected, actual, 0.00001)
    }

    // Conversion functions copied from ConversionActivity
    private fun celsiusToFahrenheit(celsius: Double): Double = celsius * 9 / 5 + 32
    private fun fahrenheitToCelsius(fahrenheit: Double): Double = (fahrenheit - 32) * 5 / 9
    private fun metersToFeet(meters: Double): Double = meters * 3.28084
    private fun feetToMeters(feet: Double): Double = feet / 3.28084
    private fun kilogramsToPounds(kg: Double): Double = kg * 2.20462
    private fun poundsToKilograms(lb: Double): Double = lb / 2.20462
}