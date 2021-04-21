package com.example.quantitymeasurementapp

import android.location.Location.convert
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import kotlin.time.Duration.Companion.convert

class MainActivity : AppCompatActivity() {
    lateinit var spinnerConversionType: Spinner
    lateinit var spinnerFromConversionType: Spinner
    lateinit var spinnerToConversionType: Spinner
    lateinit var enteredNumber: EditText
    lateinit var convertButton: Button
    lateinit var resultText: TextView
    var value:Int = 0
    var result: Double = 0.0
    val Celsius:String  = "Celsius"
    val Fahrenheit:String  = "Fahrenheit"

    lateinit  var fromConversionTypeAdapter : ArrayAdapter<CharSequence>
    lateinit  var toConversionTypeAdapter : ArrayAdapter<CharSequence>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpViewsAndAdapter()

        convertButton.setOnClickListener {
            Log.e("Spinner ", "onClick: " + spinnerFromConversionType.selectedItem.toString())
            val fromUnit = spinnerFromConversionType.selectedItem.toString()
            val toUnit = spinnerToConversionType.selectedItem.toString()

            if(enteredNumber.text.toString() == "") {
                resultText.text = "$result"
            } else {
                convert(fromUnit, toUnit)
            }
        }
    }

    private fun convert(fromUnit: String, toUnit: String) {
        val value = Integer.parseInt(enteredNumber.text.toString())
        result = if(fromUnit == Celsius || fromUnit == Fahrenheit) {
            if(fromUnit == Celsius)
                Unit.valueOf(fromUnit).convertCelsiusToFahrenheit(value)
            else
                Unit.valueOf(fromUnit).convertFahrenheitToCelsius(value)
        } else {
            val baseValue = Unit.valueOf(fromUnit).convertToBase(value)
            Unit.valueOf(toUnit).convertBaseToAnother(baseValue)
        }
        resultText.text = "$result"
    }

    private  fun setUpViewsAndAdapter() {
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