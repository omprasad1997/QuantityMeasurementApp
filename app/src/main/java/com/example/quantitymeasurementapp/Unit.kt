package com.example.quantitymeasurementapp

enum class Unit(private val conversionFactor: Double) {
    Feet(12.0),
    Inch(1.0),
    Yard(3.0 * 12),
    Cm(2.0 / 5),
    M(39.37),
    Litre(1.0),
    Gallon(3.785),
    Millilitre(0.001),
    Kg(1.0),
    G(0.001),
    Ton(1000.0),
    Fahrenheit(5.0/9),
    Celsius(9.0/5);

    fun convertToBase(value:Int) : Double {
        return value * conversionFactor
    }

    fun convertBaseToAnother(value:Double) : Double {
        return value / conversionFactor
    }

    fun convertCelsiusToFahrenheit(value: Int): Double {
        return ((value * conversionFactor) + 32)
    }

    fun convertFahrenheitToCelsius(value: Int): Double {
        return ((value - 32) * conversionFactor)
    }
}