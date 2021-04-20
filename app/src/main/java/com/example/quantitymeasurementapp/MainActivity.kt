package com.example.quantitymeasurementapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    lateinit var spinnerConversionType: Spinner
    lateinit var spinnerFromConversionType: Spinner
    lateinit var spinnerToConversionType: Spinner
    lateinit var enteredNumber: EditText
    lateinit var convertButton: Button
    lateinit var resultText: TextView
    var value:Int = 0
    var result: Double = 0.0

    lateinit  var fromConversionTypeAdapter : ArrayAdapter<CharSequence>
    lateinit  var toConversionTypeAdapter : ArrayAdapter<CharSequence>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startMethod()

        convertButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Log.e("Spinner ", "onClick: " + spinnerFromConversionType.selectedItem.toString())
                var calculation = Calculation()
                var fromUnit = spinnerFromConversionType.selectedItem.toString()
                var toUnit = spinnerToConversionType.selectedItem.toString()
                if(fromUnit == "inch" && toUnit=="cm") {
                    result = calculation.inchToCm(Integer.parseInt(enteredNumber.text.toString()))
                } else if(fromUnit == "inch" && toUnit == "m") {
                    result = calculation.inchToM(Integer.parseInt(enteredNumber.text.toString()))
                } else if(fromUnit == "inch" && toUnit == "feet") {
                    result = calculation.inchToFeet(Integer.parseInt(enteredNumber.text.toString()))
                } else if(fromUnit == "inch" && toUnit == "yard") {
                    result = calculation.inchToYard(Integer.parseInt(enteredNumber.text.toString()))
                } else if(fromUnit == "cm" && toUnit == "inch") {
                    result = calculation.cmToInch(Integer.parseInt(enteredNumber.text.toString()))
                } else if(fromUnit == "cm" && toUnit == "m") {
                    result = calculation.cmToMetre(Integer.parseInt(enteredNumber.text.toString()))
                } else if(fromUnit == "cm" && toUnit == "feet") {
                    result = calculation.cmToFeet(Integer.parseInt(enteredNumber.text.toString()))
                } else if(fromUnit == "cm" && toUnit == "yard") {
                    result = calculation.cmToYard(Integer.parseInt(enteredNumber.text.toString()))
                } else if(fromUnit == "m" && toUnit == "inch") {
                    result = calculation.mToInch(Integer.parseInt(enteredNumber.text.toString()))
                } else if(fromUnit == "m" && toUnit == "cm") {
                    result = calculation.mToCm(Integer.parseInt(enteredNumber.text.toString()))
                } else if(fromUnit == "m" && toUnit == "feet") {
                    result = calculation.mToFeet(Integer.parseInt(enteredNumber.text.toString()))
                } else if(fromUnit == "m" && toUnit == "yard") {
                    result = calculation.mToYard(Integer.parseInt(enteredNumber.text.toString()))
                } else if(fromUnit == "feet" && toUnit == "inch") {
                    result = calculation.feetToInch(Integer.parseInt(enteredNumber.text.toString()))
                }  else if(fromUnit == "feet" && toUnit == "cm") {
                    result = calculation.feetToCm(Integer.parseInt(enteredNumber.text.toString()))
                } else if(fromUnit == "feet" && toUnit == "m") {
                    result = calculation.feetToM(Integer.parseInt(enteredNumber.text.toString()))
                } else if(fromUnit == "feet" && toUnit == "yard") {
                    result = calculation.feetToYard(Integer.parseInt(enteredNumber.text.toString()))
                } else if(fromUnit == "yard" && toUnit == "inch") {
                    result = calculation.yardToInch(Integer.parseInt(enteredNumber.text.toString()))
                } else if(fromUnit == "yard" && toUnit == "cm") {
                    result = calculation.yardToCm(Integer.parseInt(enteredNumber.text.toString()))
                } else if(fromUnit == "yard" && toUnit == "m") {
                    result = calculation.yardToM(Integer.parseInt(enteredNumber.text.toString()))
                } else if(fromUnit == "yard" && toUnit == "feet") {
                    result = calculation.yardToFeet(Integer.parseInt(enteredNumber.text.toString()))
                } else if(fromUnit == "gallon" && toUnit == "litre") {
                    result = calculation.gallonToLitre(Integer.parseInt(enteredNumber.text.toString()))
                } else if(fromUnit == "gallon" && toUnit == "millilitre") {
                    result = calculation.gallonToMillilitre(Integer.parseInt(enteredNumber.text.toString()))
                } else if(fromUnit == "litre" && toUnit == "gallon") {
                    result = calculation.litreToGallon(Integer.parseInt(enteredNumber.text.toString()))
                } else if(fromUnit == "litre" && toUnit == "millilitre") {
                    result = calculation.litreToMillilitre(Integer.parseInt(enteredNumber.text.toString()))
                } else if(fromUnit == "millilitre" && toUnit == "litre") {
                    result = calculation.millilitreToLitre(Integer.parseInt(enteredNumber.text.toString()))
                } else if(fromUnit == "millilitre" && toUnit == "gallon") {
                    result = calculation.millilitreToGallon(Integer.parseInt(enteredNumber.text.toString()))
                } else if(fromUnit == "kg" && toUnit == "g") {
                    result = calculation.kilogramToGram(Integer.parseInt(enteredNumber.text.toString()))
                } else if(fromUnit == "kg" && toUnit == "ton") {
                    result = calculation.kilogramToTon(Integer.parseInt(enteredNumber.text.toString()))
                } else if(fromUnit == "g" && toUnit == "kg") {
                    result = calculation.gramToKilogram(Integer.parseInt(enteredNumber.text.toString()))
                } else if(fromUnit == "g" && toUnit == "ton") {
                    result = calculation.gramToTon(Integer.parseInt(enteredNumber.text.toString()))
                } else if(fromUnit == "ton" && toUnit == "kg") {
                    result = calculation.tonToKilogram(Integer.parseInt(enteredNumber.text.toString()))
                } else if(fromUnit == "ton" && toUnit == "g") {
                    result = calculation.tonToGram(Integer.parseInt(enteredNumber.text.toString()))
                } else if(fromUnit == "celsius" && toUnit == "fahrenheit") {
                    result = calculation.celsiusToFahrenheit(Integer.parseInt(enteredNumber.text.toString()))
                } else if(fromUnit == "fahrenheit" && toUnit == "celsius") {
                    result = calculation.fahrenheitToCelsius(Integer.parseInt(enteredNumber.text.toString()))
                }
                resultText.text = "$result"
            }
        })
    }

    private  fun startMethod() {
        spinnerConversionType     = findViewById(R.id.select_conversion_type)
        spinnerFromConversionType = findViewById(R.id.from_conversion_type_)
        spinnerToConversionType   = findViewById(R.id.to_conversion_type)
        enteredNumber             = findViewById(R.id.enteredNumber)
        convertButton             = findViewById(R.id.convert_button)
        resultText                = findViewById(R.id.resultText)

        // Create an ArrayAdapter using the string array and a default spinner layout
        val conversionTypeAdapter = ArrayAdapter.createFromResource(this, R.array.conversion_type, android.R.layout.simple_spinner_item)
        // Specify the layout to use when the list of choices appears
        conversionTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Apply the adapter to the spinner
        spinnerConversionType.adapter     = conversionTypeAdapter

        spinnerConversionType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                when(position) {
                    0 ->{
                        fromConversionTypeAdapter = ArrayAdapter.createFromResource(applicationContext,R.array.length_parameter,android.R.layout.simple_spinner_item)
                        toConversionTypeAdapter = ArrayAdapter.createFromResource(applicationContext,R.array.length_parameter,android.R.layout.simple_spinner_item)

                        spinnerFromConversionType.adapter = fromConversionTypeAdapter
                        spinnerToConversionType.adapter   = toConversionTypeAdapter

                    }
                    1 ->{
                        fromConversionTypeAdapter = ArrayAdapter.createFromResource(applicationContext,R.array.volume_parameter,android.R.layout.simple_spinner_item)
                        toConversionTypeAdapter = ArrayAdapter.createFromResource(applicationContext,R.array.volume_parameter,android.R.layout.simple_spinner_item)

                        spinnerFromConversionType.adapter = fromConversionTypeAdapter
                        spinnerToConversionType.adapter   = toConversionTypeAdapter

                    }
                    2 ->{
                        fromConversionTypeAdapter = ArrayAdapter.createFromResource(applicationContext,R.array.weight_parameter,android.R.layout.simple_spinner_item)
                        toConversionTypeAdapter = ArrayAdapter.createFromResource(applicationContext,R.array.weight_parameter,android.R.layout.simple_spinner_item)

                        spinnerFromConversionType.adapter = fromConversionTypeAdapter
                        spinnerToConversionType.adapter   = toConversionTypeAdapter
                    }
                    3->{
                        fromConversionTypeAdapter = ArrayAdapter.createFromResource(applicationContext,R.array.temperature_parameter,android.R.layout.simple_spinner_item)
                        toConversionTypeAdapter = ArrayAdapter.createFromResource(applicationContext,R.array.temperature_parameter,android.R.layout.simple_spinner_item)

                        spinnerFromConversionType.adapter = fromConversionTypeAdapter
                        spinnerToConversionType.adapter   = toConversionTypeAdapter
                    }
                }
                fromConversionTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                toConversionTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                //write log method
            }
        }
    }
}