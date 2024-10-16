package com.example.cursokotlin.Units.Unit22

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun Project106(navController: NavHostController) {
    var salaries by remember { mutableStateOf(listOf<Int>()) }
    var currentInput by remember { mutableStateOf("") }
    var isInputting by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        if (isInputting) {
            Text("Enter salaries (press Done when finished)")
            OutlinedTextField(
                value = currentInput,
                onValueChange = { currentInput = it },
                label = { Text("Enter salary") },
                modifier = Modifier.fillMaxWidth()
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = {
                        currentInput.toIntOrNull()?.let {
                            salaries = salaries + it
                            currentInput = ""
                        }
                    },
                    enabled = currentInput.isNotEmpty()
                ) {
                    Text("Add")
                }
                Button(onClick = { isInputting = false }) {
                    Text("Done")
                }
            }
        } else {
            Text("List of all salaries")
            LazyColumn {
                items(salaries) { salary ->
                    Text("$salary")
                }
            }
            Button(
                onClick = {
                    isInputting = true
                    salaries = listOf()
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Reset")
            }
        }
    }
}