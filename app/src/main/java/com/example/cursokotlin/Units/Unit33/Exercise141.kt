package com.example.cursokotlin.Units.Unit33

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

// Abstract class Account
abstract class Account(val holder: String, val amount: Double) {
    open fun print(): String {
        return "Holder: $holder\nAmount: $amount"
    }
}

// Class SavingsAccount
class SavingsAccount(holder: String, amount: Double) : Account(holder, amount) {
    override fun print(): String {
        return "Savings Account\n${super.print()}"
    }
}

// Class FixedTermDeposit
class FixedTermDeposit(holder: String, amount: Double, val term: Int, val interestRate: Double) : Account(holder, amount) {
    override fun print(): String {
        val interestAmount = amount * interestRate / 100
        return """
            Fixed-term Account
            Term in days: $term
            Interest rate: $interestRate%
            Interest amount: $interestAmount
            ${super.print()}
        """.trimIndent()
    }
}

// Jetpack Compose function
@Composable
fun Project141(navController: NavHostController, modifier: Modifier = Modifier) {
    var savingsAccountOutput by remember { mutableStateOf("") }
    var fixedTermDepositOutput by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        // Button to display SavingsAccount details
        Button(onClick = {
            val savingsAccount1 = SavingsAccount("Juan", 10000.0)
            savingsAccountOutput = savingsAccount1.print()
        }) {
            Text(text = "Show Savings Account Info", fontSize = 18.sp)
        }
        Text(text = savingsAccountOutput, fontSize = 16.sp, modifier = Modifier.padding(top = 8.dp))

        // Button to display FixedTermDeposit details
        Button(onClick = {
            val fixedTermDeposit1 = FixedTermDeposit("Ana", 5000.0, 30, 1.23)
            fixedTermDepositOutput = fixedTermDeposit1.print()
        }, modifier = Modifier.padding(top = 16.dp)) {
            Text(text = "Show Fixed-term Deposit Info", fontSize = 18.sp)
        }
        Text(text = fixedTermDepositOutput, fontSize = 16.sp, modifier = Modifier.padding(top = 8.dp))
    }
}
