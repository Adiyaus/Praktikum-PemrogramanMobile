package com.example.kalkulator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Percent
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kalkulator.ui.theme.KalkulatorTheme
import java.text.NumberFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KalkulatorTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TipCalculatorScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TipCalculatorScreen() {
    var billAmountInput by remember { mutableStateOf("") }
    var roundUp by remember { mutableStateOf(false) }

    val tipOptions = listOf("15%", "18%", "20%")
    var expanded by remember { mutableStateOf(false) }
    var selectedTipOption by remember { mutableStateOf(tipOptions[0]) }

    val amount = billAmountInput.toDoubleOrNull() ?: 0.0
    val tipPercent = selectedTipOption.removeSuffix("%").toDoubleOrNull() ?: 0.0
    val tip = calculateTip(amount, tipPercent, roundUp)

    Column(
        modifier = Modifier
            .padding(32.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Calculate Tip",
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.Start)
        )

        EditNumberField(
            label = "Bill Amount",
            value = billAmountInput,
            onValueChange = { billAmountInput = it },
            leadingIcon = { Icon(Icons.Filled.Receipt, contentDescription = "Bill Amount") }
        )

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded },
        ) {
            OutlinedTextField(
                value = selectedTipOption,
                onValueChange = {},
                readOnly = true,
                label = { Text("Tip Percentage") },
                // MODIFIKASI: Tambahkan leadingIcon di sini
                leadingIcon = { Icon(Icons.Filled.Percent, contentDescription = "Tip Percentage") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                },
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                tipOptions.forEach { selectionOption ->
                    DropdownMenuItem(
                        text = { Text(selectionOption) },
                        onClick = {
                            selectedTipOption = selectionOption
                            expanded = false
                        }
                    )
                }
            }
        }

        RoundTheTipRow(
            roundUp = roundUp,
            onRoundUpChanged = { roundUp = it }
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Tip Amount: $tip",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun EditNumberField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    leadingIcon: @Composable () -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        leadingIcon = leadingIcon,
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

@Composable
fun RoundTheTipRow(roundUp: Boolean, onRoundUpChanged: (Boolean) -> Unit, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth().size(48.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Round up tip?")
        Spacer(modifier = Modifier.weight(1f))
        Switch(checked = roundUp, onCheckedChange = onRoundUpChanged)
    }
}

private fun calculateTip(amount: Double, tipPercent: Double = 15.0, roundUp: Boolean): String {
    var tip = tipPercent / 100 * amount
    if (roundUp) {
        tip = kotlin.math.ceil(tip)
    }
    return NumberFormat.getCurrencyInstance().format(tip)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KalkulatorTheme {
        TipCalculatorScreen()
    }
}