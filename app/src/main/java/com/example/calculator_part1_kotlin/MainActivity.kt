package com.example.calculator_part1_kotlin

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    var firstNumber:Double = 0.0
    var secondNumber:Double = 0.0
    var res :Double= 0.0
    var Operation = 0.toChar()
    var outp = ""
    private var isOpClicked = false
    var isNumclicked = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        zero.setOnClickListener{
            if(screen.text.isEmpty()){
            screen.setText("0")
        }
        else
        {
            var c:Char
            c=screen.text.toString()[0]
            if((screen.text.contains("." ) && c=='0') || c!='0'){
                screen.append("0")
            }
        }}
        one.setOnClickListener{
            setTextFields("1")
            isOpClicked = false
            isNumclicked = true}
        two.setOnClickListener{
            setTextFields("2")
            isOpClicked = false
            isNumclicked = true}
        three.setOnClickListener{
            setTextFields("3")
            isOpClicked = false
            isNumclicked = true}
        four.setOnClickListener{
            setTextFields("4")
            isOpClicked = false
            isNumclicked = true}
        five.setOnClickListener{
            setTextFields("5")
            isOpClicked = false
            isNumclicked = true}
        six.setOnClickListener{
            setTextFields("6")
            isOpClicked = false
            isNumclicked = true}
        seven.setOnClickListener{
            setTextFields("7")
            isOpClicked = false
            isNumclicked = true}
        eight.setOnClickListener{
            setTextFields("8")
            isOpClicked = false
            isNumclicked = true}
        nine.setOnClickListener{
            setTextFields("9")
            isOpClicked = false
            isNumclicked = true}

        buttonDot.setOnClickListener {
            val s: String = screen.getText().toString()
            if (s.isEmpty()) {
                screen.append("0.")
            } else if (!s.contains(".")) {
                screen.append(".")
            }
        }
        buttonEqual.setOnClickListener{
            if (!screen.getText().toString().isEmpty()) {
                secondNumber = screen.getText().toString().toDouble()
                if (isNumclicked == true && isOpClicked == false) {
                    if (Operation == '+') {
                        res = firstNumber + secondNumber
                    }
                    if (Operation == '-') {
                        res = firstNumber - secondNumber
                    }
                    if (Operation == '*') {
                        res = firstNumber * secondNumber
                    }
                    if (Operation == '/' && secondNumber!=0.0) {
                        res = firstNumber / secondNumber
                    }

                    if (Operation == '^') {
                        res = Math.pow(firstNumber, secondNumber)
                    }
                    if (Operation == 'n') {
                        res = Math.pow(firstNumber, 1 / secondNumber)
                    }
                }
                if(Operation=='/'&&secondNumber==0.0){
                    screen2.setText("Error")
                }else {
                outp = res.toString()
                screen.setText(outp)
                }
            }
        }
        plus.setOnClickListener {
            Operation = '+'
            screen2.text = "+"
            if (isNumclicked) {
                if (isOpClicked == false) {
                    firstNumber = screen.getText().toString().toDouble()
                    screen.setText("")
                }
                isOpClicked = true
                isNumclicked = false
            }
        }
        minus.setOnClickListener {
            Operation = '-'
            screen2.text = "-"
            if (isNumclicked) {
                if (isOpClicked == false) {
                    firstNumber = screen.getText().toString().toDouble()
                    screen.setText("")
                }
                isOpClicked = true
                isNumclicked = false
            }
        }
        division.setOnClickListener {
            Operation = '/'
            if (isNumclicked) {
                if (isOpClicked == false) {
                    firstNumber = screen.getText().toString().toDouble()
                    screen.setText("")
                }
                isOpClicked = true
                isNumclicked = false
            } }
        multiply.setOnClickListener {
            Operation = '*'
            screen2.text = "*"
            if (isNumclicked) {
                if (isOpClicked == false) {
                    firstNumber = screen.getText().toString().toDouble()
                    screen.setText("")
                }
                isOpClicked = true
                isNumclicked = false
            }
        }
        power.setOnClickListener {
            Operation = '^'
            screen2.text = "^"
            if (isNumclicked) {
                if (isOpClicked == false) {
                    firstNumber = screen.getText().toString().toDouble()
                    screen.setText("")
                }
                isOpClicked = true
                isNumclicked = false
            }
        }
        Square.setOnClickListener {
            if (isNumclicked) {
                firstNumber = screen.getText().toString().toDouble()
                res = sqrt(firstNumber)
                outp = res.toString()
                screen.setText(outp)
            } }
        percent.setOnClickListener {
            if (isNumclicked) {
                firstNumber = screen.getText().toString().toDouble()
                res = firstNumber / 100
                outp = res.toString()
                screen.setText(outp)
            }
        }
        backspace.setOnClickListener {
            var displayedElement: String = screen.getText().toString()
            val length = displayedElement.length
            if (length > 0) {
                displayedElement = displayedElement.substring(0, length - 1)
                screen.setText(displayedElement)
            } }
        delete.setOnClickListener {
            screen.setText("")
            isNumclicked = false
            firstNumber = 0.0
            secondNumber = 0.0
            isOpClicked = false
            screen2.text = ""
        }
        if (savedInstanceState != null) {
            screen.setText(savedInstanceState.getString("first_val"))
            screen2.text = savedInstanceState.getString("operScreen")
            Operation = savedInstanceState.getChar("operation")
            isNumclicked = savedInstanceState.getBoolean("isNumClicked")
            isOpClicked = savedInstanceState.getBoolean("isOpClicked")
            firstNumber = savedInstanceState.getDouble("firstnumber")
        }
    }
    fun setTextFields(str: String){
        screen.append(str)
    }

    fun log10(view: View) {
        if (isNumclicked && !screen.getText().toString().isEmpty()) {
            firstNumber = screen.getText().toString().toDouble()
            if (firstNumber > 0) {
                res = Math.log10(firstNumber)
                outp = res.toString()
                screen.setText(outp)
            } else {
                screen2.setText("Error")
            }
        }
    }
    fun sin(view: View) {
        if (isNumclicked) {
            firstNumber = screen.getText().toString().toDouble()
            res = Math.sin(Math.toRadians(firstNumber))
            outp = res.toString()
            screen.setText(outp)
        }
    }
    fun tan(view: View) {
        if (isNumclicked) {
            firstNumber = screen.getText().toString().toDouble()
            if (firstNumber % 90 == 0.0) {
                screen2.setText("Infinity")
            } else {
                res = Math.tan(Math.toRadians(firstNumber))
                outp = res.toString()
                screen.setText(outp)
            }
        }}
    fun fact(view: View) {
        if (isNumclicked) {
            firstNumber = screen.getText().toString().toDouble()
            if (firstNumber < 0 || firstNumber > 20) {
                screen2.setText("Error")
            } else {
                var factt: Long = 1
                var i = 1
                while (i <= firstNumber) {
                    factt = factt * i
                    i++
                }
                res = factt.toDouble()
                outp = res.toString()
                screen.setText(outp)
            }
        }
    }
    fun nthroot(view: View) {
        Operation = 'n'
        screen2.text = "NthRootOf"
        if (isNumclicked) {
            if (isOpClicked == false) {
                firstNumber = screen.getText().toString().toDouble()
                screen.setText("")
            }
            isOpClicked = true
            isNumclicked = false
        }
    }
    fun cos(view: View) {
        if (isNumclicked) {
            firstNumber = screen.getText().toString().toDouble()
            res = Math.cos(Math.toRadians(firstNumber))
            outp = res.toString()
            screen.setText(outp)
        }}
    fun ln(view: View) {
        if (isNumclicked) {
            firstNumber = screen.getText().toString().toDouble()
            if (firstNumber > 0) {
                res = Math.log(firstNumber)
                outp = res.toString()
                screen.setText(outp)
            } else {
                screen2.setText("Error")
            }
        }}

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("first_val", screen.getText().toString())
        outState.putString("operScreen", screen2.text.toString())
        outState.putBoolean("isOpClicked", isOpClicked)
        outState.putBoolean("isNumClicked", isNumclicked)
        outState.putChar("operation", Operation)
        outState.putDouble("firstnumber", firstNumber)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.getString("first_val")
        savedInstanceState.getString("operScreen")
        savedInstanceState.getBoolean("isOpClicked")
        savedInstanceState.getBoolean("isNumClicked")
        savedInstanceState.getChar("operation")
        savedInstanceState.getDouble("firstnumber")
    }
}
