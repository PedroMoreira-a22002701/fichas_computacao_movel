package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.calculadora.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()

        binding.button0.setOnClickListener {
            Log.i(TAG, "Click no botão 0")
            if (binding.textVisor.text.toString() != "0") {
                binding.textVisor.append("0")
            }
        }
        binding.button1.setOnClickListener {
            Log.i(TAG, "Click no botão 1")
            if (binding.textVisor.text.toString() == "0") {
                binding.textVisor.text = "1"
            } else {
                binding.textVisor.append("1")
            }
        }
        binding.button2.setOnClickListener {
            Log.i(TAG, "Click no botão 2")
            if (binding.textVisor.text.toString() == "0") {
                binding.textVisor.text = "2"
            } else {
                binding.textVisor.append("2")
            }
        }
        binding.button3.setOnClickListener {
            Log.i(TAG, "Click no botão 3")
            if (binding.textVisor.text.toString() == "0") {
                binding.textVisor.text = "3"
            } else {
                binding.textVisor.append("3")
            }
        }
        binding.button4.setOnClickListener {
            Log.i(TAG, "Click no botão 4")
            if (binding.textVisor.text.toString() == "0") {
                binding.textVisor.text = "4"
            } else {
                binding.textVisor.append("4")
            }
        }
        binding.button5.setOnClickListener {
            Log.i(TAG, "Click no botão 5")
            if (binding.textVisor.text.toString() == "0") {
                binding.textVisor.text = "5"
            } else {
                binding.textVisor.append("5")
            }
        }
        binding.button6.setOnClickListener {
            Log.i(TAG, "Click no botão 6")
            if (binding.textVisor.text.toString() == "0") {
                binding.textVisor.text = "6"
            } else {
                binding.textVisor.append("6")
            }
        }

        binding.buttonAdition.setOnClickListener {
            addSymbol("+")
        }
        binding.buttonDot.setOnClickListener {
            addSymbol(".")
        }
        binding.buttonEquals.setOnClickListener {
            equals()
        }
        binding.buttonReset.setOnClickListener {
            clear()
        }
        binding.buttonBackspace.setOnClickListener {
            backspace()
        }
        binding.buttonInterrogation.setOnClickListener {
            val lastOperation = getLastOperation(binding.textVisor.text.toString())
            Log.i(TAG, "Última operação: $lastOperation")
        }
    }

    private fun equals() {
        Log.i(TAG, "Click no botão =")
        val expression = ExpressionBuilder(binding.textVisor.text.toString()).build()
        binding.textVisor.text = expression.evaluate().toString()
        Log.i(TAG, "O resultado da expressão é ${binding.textVisor.text}")
    }
    private fun addSymbol(symbol: String) {
        Log.i(TAG, "Click no botão $symbol")
        binding.textVisor.append(symbol)
    }
    private fun clear() {
        Log.i(TAG, "Click no botão C")
        binding.textVisor.text = "0"
    }
    private fun backspace() {
        Log.i(TAG, "Click no botão «")
        val text = binding.textVisor.text.toString()
        if (text.isNotEmpty()) {
            binding.textVisor.text = text.substring(0, text.length - 1)
        }
    }
    private fun getLastOperation(expression: String): String {
        Log.i(TAG, "Click no botão ?")
        val operators = listOf("+", "-", "*", "/")
        var lastOperatorIndex = -1

        for (operator in operators) {
            val index = expression.lastIndexOf(operator)
            if (index > lastOperatorIndex) {
                lastOperatorIndex = index
            }
        }

        return if (lastOperatorIndex == -1) {
            expression
        } else {
            expression.substring(lastOperatorIndex)
        }
    }
}




