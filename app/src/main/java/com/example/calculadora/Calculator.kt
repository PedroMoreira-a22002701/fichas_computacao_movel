package com.example.calculadora

import Operation
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.calculadora.databinding.FragmentCalculatorBinding
import net.objecthunter.exp4j.ExpressionBuilder

class Calculator {

    private val TAG = CalculatorFragment::class.java.simpleName
    private val operations = mutableListOf<Operation>()


    fun equals(binding: FragmentCalculatorBinding) {
        Log.i(TAG, "Click no botão =")
        val expression = binding.textVisor.text.toString()
        val result = ExpressionBuilder(expression).build().evaluate().toString()
        val timestamp = System.currentTimeMillis()
        val operation = Operation(expression, result, timestamp)
        operations.add(operation)
        binding.textVisor.text = result
        Log.i(TAG, "O resultado da expressão é $result")
    }
    fun addSymbol(symbol: String,binding: FragmentCalculatorBinding) {
        Log.i(TAG, "Click no botão $symbol")
        binding.textVisor.append(symbol)
    }
    fun clear(binding: FragmentCalculatorBinding) {
        Log.i(TAG, "Click no botão C")
        binding.textVisor.text = "0"
    }
    fun backspace(binding: FragmentCalculatorBinding) {
        Log.i(TAG, "Click no botão «")
        val text = binding.textVisor.text.toString()
        if (text.isNotEmpty()) {
            binding.textVisor.text = text.substring(0, text.length - 1)
        }
    }
    fun getLastOperation(expression: String): String {
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
    fun history(): List<Operation> {
        Log.i(TAG,operations.toString())
        Log.i(TAG, "Getting operations history")
        return operations
    }

}

