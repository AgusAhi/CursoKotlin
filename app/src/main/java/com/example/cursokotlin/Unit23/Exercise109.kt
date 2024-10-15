package com.example.cursokotlin.Unit22

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

class Persona(val nombre: String, val edad: Int) {
    fun imprimir() = "Nombre: $nombre y tiene una edad de $edad"
    fun esMayorEdad() = edad >= 18
}

class Project109 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project109(modifier = Modifier, navController = rememberNavController())
        }
    }
}

@Composable
fun Project109(modifier: Modifier = Modifier, navController: NavHostController) {
    var numberInput by remember { mutableStateOf("") }
    var array by remember { mutableStateOf(IntArray(0)) } // Initially empty array
    var currentIndex by remember { mutableStateOf(0) }
    var inputComplete by remember { mutableStateOf(false) }

    var nombrePersona by remember { mutableStateOf("") }
    var edadPersona by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Array input section (unchanged from Project106)
        if (!inputComplete) {
            Text("Enter array size:")
            OutlinedTextField(
                value = numberInput,
                onValueChange = { numberInput = it },
                label = { Text("Enter size") },
                modifier = Modifier.fillMaxWidth()
            )
            Button(
                onClick = {
                    val size = numberInput.toIntOrNull()
                    if (size != null && size > 0) {
                        array = IntArray(size) // Create array with specified size
                        currentIndex = 0
                        numberInput = ""
                        inputComplete = false
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = numberInput.isNotEmpty()
            ) {
                Text("Set Array Size")
            }
        } else {
            Text("Enter elements:")
            OutlinedTextField(
                value = numberInput,
                onValueChange = { numberInput = it },
                label = { Text("Enter number ${currentIndex + 1}") },
                modifier = Modifier.fillMaxWidth()
            )
            Button(
                onClick = {
                    val number = numberInput.toIntOrNull()
                    if (number != null) {
                        array[currentIndex] = number
                        currentIndex++
                        numberInput = ""
                        if (currentIndex == array.size) {
                            inputComplete = true
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = !inputComplete && numberInput.isNotEmpty()
            ) {
                Text("Submit (${currentIndex}/ ${array.size})")
            }
        }

        // Persona section
        Text("Enter Persona details:")
        OutlinedTextField(
            value = nombrePersona,
            onValueChange = { nombrePersona = it },
            label = { Text("Enter name") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = edadPersona.toString(), // Convert int to String
            onValueChange = { edadPersona = it.toIntOrNull() ?: 0 }, // Handle invalid input
            label = { Text("Enter age") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = {
                val persona = Persona(nombrePersona, edadPersona)
                // Show Persona information (add your logic here)
                println(persona.imprimir())
                println(persona.esMayorEdad())
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Create Persona")
        }
    }
}