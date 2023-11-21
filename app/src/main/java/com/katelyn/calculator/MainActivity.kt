package com.katelyn.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.abs
import kotlin.math.sqrt
import kotlin.math.pow


class MainActivity : AppCompatActivity() {
    //property will be initialized before it is used
    lateinit var displayResult: TextView
    lateinit var edtFirst: EditText
    lateinit var edtSecond: EditText
    lateinit var addition: Button
    lateinit var subtraction: Button
    lateinit var multiplication: Button
    lateinit var division: Button
    lateinit var squareRoot: Button
    lateinit var power: Button
    lateinit var btnStatistical: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //access the IDs by using a View

        displayResult = findViewById(R.id.displayResult)
        edtFirst = findViewById(R.id.edtFirst)
        edtSecond = findViewById(R.id.edtSecond)
        addition = findViewById(R.id.addition)
        subtraction = findViewById(R.id.subtraction)
        multiplication = findViewById(R.id.multiplication)
        division = findViewById(R.id.division)
        squareRoot = findViewById(R.id.squareRoot)
        power = findViewById(R.id.power)
        btnStatistical = findViewById(R.id.btnStatistical)


        //creating  onclick function for each button

        //addition button
        addition.setOnClickListener {
            val res1 = edtFirst.text.toString().toInt()
            val res2 = edtSecond.text.toString().toInt()
            addition(res1, res2)
        }

        //subtraction button
        subtraction.setOnClickListener {
            val res1 = edtFirst.text.toString().toInt()
            val res2 = edtSecond.text.toString().toInt()
            subtraction(res1, res2)
        }

        multiplication.setOnClickListener {
            val res1 = edtFirst.text.toString().toInt()
            val res2 = edtSecond.text.toString().toInt()
            multiplication(res1, res2)
        }

        //division button
        division.setOnClickListener {
            val res1 = edtFirst.text.toString().toInt()
            val res2 = edtSecond.text.toString().toInt()
            division(res1, res2)
        }

        //square root button
        squareRoot.setOnClickListener {
            val res1 = edtFirst.text.toString().toInt()
            squareRoot(res1)

        }

        //power button
        power.setOnClickListener {
            val res1 = edtFirst.text.toString().toInt()
            val res2 = edtSecond.text.toString().toInt()
            power(res1, res2)
        }

        btnStatistical.setOnClickListener{
            val intent = Intent(this, StatisticalFunction::class.java)
            startActivity(intent)
        }
    }



    //adding private fun for formulas


    //calculation and display for addition
    private fun addition(res1: Int, res2: Int) {
        val result = res1 + res2
        displayResult.text = "$res1 + $res2 = $result"
    }

    //calculation and display for subtraction
    private fun subtraction(res1: Int, res2: Int) {
        val result = res1 - res2
        displayResult.text = "$res1 - $res2 = $result"
    }

    //calculation and display for multiplication
    private fun multiplication(res1: Int, res2: Int) {
        val result = res1 * res2
        displayResult.text = "$res1 x $res2 = $result"
    }

    //calculation and display for division
    private fun division(res1: Int, res2: Int) {

        if (res2 != 0) {
            val result = res1 / res2
            displayResult.text = "$res1 / $res2 = $result"

        } else {
            displayResult.text = "division by 0 is not allowed"

        }
    }

    //calculation and display for squareRoot
    private fun squareRoot(res1: Int) {
        val res1 = edtFirst.text.toString().toDoubleOrNull() ?: return

            if (res1<0){
                val squareRoot = sqrt(abs(res1))
                displayResult.text = "sqrt($res1) = $squareRoot i"
            }
        else {
                val squareRoot = sqrt(res1)
                displayResult.text = "sqrt($res1)= $squareRoot"
            }

    }


    //calculation and display for power
    private fun power(res1: Int, res2: Int) {
        val res1 = edtFirst.text.toString().toDoubleOrNull() ?: return
        val res2 = edtSecond.text.toString().toDoubleOrNull() ?: return

        val result = res1.pow(res2)

        displayResult.text = "$res1^$res2 =$result"
    }


}



