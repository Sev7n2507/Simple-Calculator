package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_add.setOnClickListener () {
            add()
        }

        btn_subtract.setOnClickListener () {
            subtract()
        }

        btn_multiply.setOnClickListener () {
            multiply()
        }

        btn_divide.setOnClickListener () {
            divide()
        }
    }

    fun add() {
        if (inputIsNotEmpty()) {
            val input1 = edt1.text.toString().trim().toBigDecimal()
            val input2 = edt2.text.toString().trim().toBigDecimal()
            tv_result.text = input1.add(input2).toString()
        }
    }

    fun subtract() {
        if (inputIsNotEmpty()) {
            val input1 = edt1.text.toString().trim().toBigDecimal()
            val input2 = edt2.text.toString().trim().toBigDecimal()
            tv_result.text = input1.subtract(input2).toString()
        }
    }

    fun multiply() {
        if (inputIsNotEmpty()) {
            val input1 = edt1.text.toString().trim().toBigDecimal()
            val input2 = edt2.text.toString().trim().toBigDecimal()
            tv_result.text = input1.multiply(input2).toString()
        }
    }

    fun divide() {
        if (inputIsNotEmpty()) {
            val input1 = edt1.text.toString().trim().toBigDecimal()
            val input2 = edt2.text.toString().trim().toBigDecimal()
            if (input2.compareTo(BigDecimal.ZERO) == 0) {
                edt2.error = "Invalid input"
            } else {
                tv_result.text = input1.divide(input2, 10, RoundingMode.HALF_UP).toString()
            }

        }
    }

    fun inputIsNotEmpty(): Boolean {
        var b = true
        if (edt1.text.toString().trim().isEmpty() ) {

            edt1.error = "Required"
            b = false
        }
        if (edt2.text.toString().trim().isEmpty() ) {

            edt2.error = "Required"
            b = false
        }
        return b
    }
}