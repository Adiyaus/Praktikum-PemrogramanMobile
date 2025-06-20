package com.example.m3xml

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.m3xml.databinding.ActivityMainBinding // Ganti dengan package Anda

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}