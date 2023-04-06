package com.example.calculadora


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.calculadora.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        NavigationManager.goToCalculatorFragment(supportFragmentManager)
    }
}
