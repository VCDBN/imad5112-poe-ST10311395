package com.katelyn.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class StatisticalFunction : AppCompatActivity() {

    private val maxNumbers = 10
    private val numbers = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistical_function)
        //linking ids
        val edtEnterNumber = findViewById<EditText>(R.id.edtEnterNumber)
        val add = findViewById<Button>(R.id.add)
        val numberStored = findViewById<TextView>(R.id.numberStored)
        val clear = findViewById<Button>(R.id.clear)
        val calcAverageButton = findViewById<Button>(R.id.calcAverage)
        val averageAnswer = findViewById<TextView>(R.id.AverageAnswer)
        val minNMax = findViewById<Button>(R.id.MinNMax)
        val message = findViewById<TextView>(R.id.message)


        //setting onclick functions
        add.setOnClickListener{
            val numberEntered = edtEnterNumber.text.toString()
            if (numberEntered.isNotEmpty()){
                val number = numberEntered.toInt()
                if (numbers.size < maxNumbers) {
                    numbers.add(number)
                    updateNumber(numberStored)
                } else {
                    // Handle case when the maximum number of inputs is reached
                    message.text =  "maximum numbers have been reached"
                }
            } else {
                // Handle case when the input is empty
                message.text = "please enter a number"
            }

        }
        clear.setOnClickListener {
            numbers.clear()
            updateNumber(numberStored)

        }
        calcAverageButton.setOnClickListener {
            val average = calculateAverage()
            averageAnswer.text = "The average is $average"

        }

        minNMax.setOnClickListener {
            val minNMaxString = findMinMax(numbers)
            averageAnswer.text = minNMaxString
        }
    }

    private fun updateNumber(numberStored: TextView) {
        val numbersEntered = numbers.joinToString(", ")
        numberStored.text = "Entered Numbers: $numbersEntered\nCount: ${numbers.size}"
    }
    private fun calculateAverage(): Double {
        if (numbers.isEmpty()) {
            return 0.0
        }

        var sum = 0
        for (number in numbers) {
            sum += number
        }

        return sum.toDouble() / numbers.size
}
    private fun findMinMax(numbers: List<Int>): String {
        if (numbers.isEmpty()) {
            return "No numbers to find"
        }

        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE

        for (number in numbers) {
            if (number < min) {
                min = number
            }
            if (number > max) {
                max = number
            }
        }

        return "Min: $min\nMax: $max"
    }
}


