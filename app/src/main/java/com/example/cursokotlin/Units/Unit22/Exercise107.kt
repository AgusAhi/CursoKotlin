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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Project107(navController: NavHostController) {
    val navController = rememberNavController()
    var array by remember { mutableStateOf(intArrayOf()) }

    NavHost(navController, startDestination = "input") {
        composable("input") {
            InputScreen(navController) { newArray ->
                array = newArray
            }
        }
        composable("display") {
            DisplayScreen(navController, array)
        }
        composable("sum") {
            SumScreen(navController, array)
        }
    }
}

@Composable
fun InputScreen(navController: NavHostController, onArrayCreated: (IntArray) -> Unit) {
    var size by remember { mutableStateOf("") }
    var currentInput by remember { mutableStateOf("") }
    var currentIndex by remember { mutableStateOf(0) }
    var tempArray by remember { mutableStateOf(intArrayOf()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        if (tempArray.isEmpty()) {
            OutlinedTextField(
                value = size,
                onValueChange = { size = it },
                label = { Text("Enter array size") },
                modifier = Modifier.fillMaxWidth()
            )
            Button(
                onClick = {
                    size.toIntOrNull()?.let {
                        tempArray = IntArray(it)
                    }
                },
                enabled = size.isNotEmpty()
            ) {
                Text("Set Size")
            }
        } else {
            Text("Enter element ${currentIndex + 1} of ${tempArray.size}")
            OutlinedTextField(
                value = currentInput,
                onValueChange = { currentInput = it },
                label = { Text("Enter element") },
                modifier = Modifier.fillMaxWidth()
            )
            Button(
                onClick = {
                    currentInput.toIntOrNull()?.let {
                        tempArray[currentIndex] = it
                        currentIndex++
                        currentInput = ""
                        if (currentIndex == tempArray.size) {
                            onArrayCreated(tempArray)
                            navController.navigate("display")
                        }
                    }
                },
                enabled = currentInput.isNotEmpty()
            ) {
                Text("Add Element")
            }
        }
    }
}

@Composable
fun DisplayScreen(navController: NavHostController, array: IntArray) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Array Contents:")
        LazyColumn {
            items(array.toList()) { item ->
                Text(item.toString())
            }
        }
        Button(onClick = { navController.navigate("sum") }) {
            Text("Calculate Sum")
        }
    }
}

@Composable
fun SumScreen(navController: NavHostController, array: IntArray) {
    val sum = array.sum()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Sum of all elements: $sum")
        Button(onClick = { navController.navigate("input") }) {
            Text("Start Over")
        }
    }
}