package com.example.calculadora

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.calculadora.databinding.FragmentCalculatorBinding


class CalculatorFragment : Fragment() {
    private lateinit var binding: FragmentCalculatorBinding
    private val calculator = NavigationManager.getCalculator()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCalculatorBinding.inflate(inflater, container, false)
        return binding.root
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
            calculator?.addSymbol("+",binding)
        }
        binding.buttonDot.setOnClickListener {
            calculator?.addSymbol(".",binding)
        }
        binding.buttonEquals.setOnClickListener {
            calculator?.equals(binding)
        }
        binding.buttonReset.setOnClickListener {
            calculator?.clear(binding)
        }
        binding.buttonBackspace.setOnClickListener {
            calculator?.backspace(binding)
        }
        binding.buttonInterrogation.setOnClickListener {
            val lastOperation = calculator?.getLastOperation(binding.textVisor.text.toString())
            Log.i(TAG, "Última operação: $lastOperation")
        }


    }

}