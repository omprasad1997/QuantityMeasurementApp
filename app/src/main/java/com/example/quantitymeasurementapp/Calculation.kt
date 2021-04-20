package com.example.quantitymeasurementapp

const val inchToCentimetre    = 2.54
const val inchToMetre = 39.37
const val inchToFeet = 12.0
const val inchToYard = 36.0
const val cmToMetre    = 100.0
const val cmToFeet    = 30.48
const val cmToYard    = 91.44
const val mToFeet   = 3.281
const val mToYard   = 1.094
const val feetToYard   = 3.0
const val gallonToLitre = 3.785
const val gallonToMillilitre = 3785.0
const val litreToMillilitre = 1000.0
const val kilogramToGram = 1000.0
const val kilogramToTon = 1000.0
const val gramToTon = 907185.0
const val celsiusToFahrenheitFactor = 0.55
const val fahrenheitToCelsiusFactor = 1.8

class Calculation {
    fun inchToCm(value: Int): Double {
        return value * inchToCentimetre
    }

    fun inchToM(value: Int): Double {
        return  value / inchToMetre
    }

    fun inchToFeet(value: Int): Double {
        return value / inchToFeet
    }

    fun inchToYard(value: Int): Double {
        return  value / inchToYard
    }

    fun cmToInch(value: Int): Double {
        return value / inchToCentimetre
    }

    fun cmToMetre(value: Int): Double {
        return value / cmToMetre
    }

    fun cmToFeet(value: Int): Double {
        return value / cmToFeet
    }

    fun cmToYard(value: Int): Double {
        return value / cmToYard
    }

    fun mToInch(value: Int): Double {
        return value * inchToMetre
    }

    fun mToCm(value: Int): Double {
        return value * cmToMetre
    }

    fun mToFeet(value: Int): Double {
        return value * mToFeet
    }

    fun mToYard(value: Int): Double {
        return value * mToYard
    }

    fun feetToInch(value: Int): Double {
        return value * inchToFeet
    }

    fun feetToCm(value: Int): Double {
        return value * cmToFeet
    }

    fun feetToM(value: Int): Double {
        return value / mToFeet
    }

    fun feetToYard(value: Int): Double {
        return value / feetToYard
    }

    fun yardToInch(value: Int): Double {
        return value  * inchToYard
    }

    fun yardToCm(value: Int): Double {
        return value * cmToYard
    }

    fun yardToM(value: Int): Double {
        return value / mToYard
    }

    fun yardToFeet(value: Int): Double {
        return value * feetToYard
    }

    fun gallonToLitre(value: Int): Double {
        return value * gallonToLitre
    }

    fun gallonToMillilitre(value: Int): Double {
        return  value * gallonToMillilitre
    }

    fun litreToMillilitre(value: Int): Double {
        return  value * litreToMillilitre
    }

    fun litreToGallon(value: Int): Double {
        return value / gallonToLitre
    }

    fun millilitreToLitre(value: Int): Double {
        return value / litreToMillilitre
    }

    fun millilitreToGallon(value: Int): Double {
        return value / gallonToMillilitre
    }

    fun kilogramToGram(value: Int): Double {
        return value * kilogramToGram
    }

    fun kilogramToTon(value: Int): Double {
        return value / kilogramToTon
    }

    fun gramToKilogram(value: Int): Double {
        return value / kilogramToGram
    }

    fun gramToTon(value: Int): Double {
        return value / gramToTon
    }

    fun tonToKilogram(value: Int): Double {
        return value * kilogramToTon
    }

    fun tonToGram(value: Int): Double {
        return value * gramToTon
    }

    fun celsiusToFahrenheit(value: Int): Double {
        return ((value * fahrenheitToCelsiusFactor) + 32)
    }

    fun fahrenheitToCelsius(value: Int): Double {
        return ((value - 32) * celsiusToFahrenheitFactor)
    }
}