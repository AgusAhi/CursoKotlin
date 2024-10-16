package com.example.cursokotlin.Units.Unit10

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun Project46(modifier: Modifier = Modifier, navController: NavHostController) {
    var accountNumber by remember { mutableStateOf("") } // Input for account number
    var balance by remember { mutableStateOf("") } // Input for account balance
    var accountStatus by remember { mutableStateOf("") } // Stores the status of the account
    var creditorSum by remember { mutableStateOf(0.0) } // Total sum of creditor balances
    var isProcessFinished by remember { mutableStateOf(false) } // Tracks if the process is finished
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (!isProcessFinished) {
            // Input field for account number
            OutlinedTextField(
                value = accountNumber,
                onValueChange = { accountNumber = it },
                label = { Text("Enter account number (negative to finish)") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                singleLine = true,
            )

            // Input field for account balance (only visible if account number is valid)
            if (accountNumber.toIntOrNull() != null && accountNumber.toInt() >= 0) {
                OutlinedTextField(
                    value = balance,
                    onValueChange = { balance = it },
                    label = { Text("Enter account balance") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    singleLine = true,
                )
            }

            // Button to process the account
            Button(
                onClick = {
                    val account = accountNumber.toIntOrNull()
                    val accountBalance = balance.toDoubleOrNull()

                    if (account != null && account >= 0 && accountBalance != null) {
                        when {
                            accountBalance > 0 -> {
                                accountStatus = "Creditor"
                                creditorSum += accountBalance // Sum creditor balance
                            }
                            accountBalance < 0 -> accountStatus = "Debtor"
                            else -> accountStatus = "Neutral"
                        }
                        // Reset input fields
                        accountNumber = ""
                        balance = ""
                    } else if (account != null && account < 0) {
                        isProcessFinished = true // Finish the process if the account number is negative
                    }
                },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "Add account")
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Display the status of the last processed account
            Text(
                text = "Account status: $accountStatus",
                modifier = Modifier.padding(10.dp)
            )
        } else {
            // Show the final sum of creditor balances when the process is finished
            Text(
                text = "Total creditor balances: $creditorSum",
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}
