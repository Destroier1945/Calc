package com.example.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var firstOperand = ""
    private var operator = ""
    private  var isOperatorClicked = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val display = findViewById<TextView>(R.id.display)


        val numberButtons =  listOf<Button>(
            findViewById(R.id.button0),
            findViewById(R.id.button1),
            findViewById(R.id.button2),
            findViewById(R.id.button3),
            findViewById(R.id.button4),
            findViewById(R.id.button5),
            findViewById(R.id.button6),
            findViewById(R.id.button7),
            findViewById(R.id.button8),
            findViewById(R.id.button9),
        )
        val operatorButtons = listOf<Button>(
            findViewById(R.id.buttonDivider),
            findViewById(R.id.buttonDot),
            findViewById(R.id.buttonMultiplier),
            findViewById(R.id.buttonMinus)
        )

        for (button in operatorButtons){
            button.setOnClickListener{
                if (!isOperatorClicked){
                    firstOperand = display.text.toString()
                    operator = button.text.toString()
                    isOperatorClicked = true
                }
            }
        }


        val buttonEqual = findViewById<Button>(R.id.buttonEqual)
        buttonEqual.setOnClickListener{
            val secondOperand = display.text.toString()
            val result = performCalculation(
                firstOperand, secondOperand, operator
            )
            display.text = result
            isOperatorClicked = true
        }


    }

    private fun performCalculation(
        firstOperand: String,
        secondOperand: String,
        operator: String
    ): String {
        return when (operator){
            "+" -> (firstOperand.toDouble() + secondOperand.toDouble()).toString()
            "-" -> (firstOperand.toDouble() - secondOperand.toDouble()).toString()
            "*" -> (firstOperand.toDouble() * secondOperand.toDouble()).toString()
            "/" -> (firstOperand.toDouble() / secondOperand.toDouble()).toString()
            else -> {
                ""
            }
        }
    }
}