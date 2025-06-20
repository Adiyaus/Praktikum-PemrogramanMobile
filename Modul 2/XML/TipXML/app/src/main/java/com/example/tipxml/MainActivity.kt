package com.example.tipxml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import com.example.tipxml.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tipOptions = resources.getStringArray(R.array.tip_percentage_options)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, tipOptions)
        binding.tipPercentageAutocomplete.setAdapter(adapter)
        binding.tipPercentageAutocomplete.setText(tipOptions[0], false)

        setupListeners()
        calculateAndDisplayTip()
    }

    private fun setupListeners() {
        binding.billAmountEditText.addTextChangedListener { calculateAndDisplayTip() }
        binding.roundUpSwitch.setOnCheckedChangeListener { _, _ -> calculateAndDisplayTip() }

        binding.tipPercentageAutocomplete.setOnItemClickListener { _, _, _, _ ->
            calculateAndDisplayTip()
        }
    }

    private fun calculateAndDisplayTip() {
        val billAmountString = binding.billAmountEditText.text.toString()
        val tipPercentString = binding.tipPercentageAutocomplete.text.toString()

        val amount = billAmountString.toDoubleOrNull() ?: 0.0
        val tipPercent = tipPercentString.removeSuffix("%").toDoubleOrNull() ?: 0.0
        val roundUp = binding.roundUpSwitch.isChecked

        var tip = tipPercent / 100 * amount
        if (roundUp) {
            tip = kotlin.math.ceil(tip)
        }

        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResultTextView.text = "Tip Amount: $formattedTip"
    }

    private fun android.widget.EditText.addTextChangedListener(onTextChanged: (String) -> Unit) {
        this.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                onTextChanged(s.toString())
            }
            override fun afterTextChanged(s: Editable?) {}
        })
    }
}