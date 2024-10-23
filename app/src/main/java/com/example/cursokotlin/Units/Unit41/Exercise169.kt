package com.example.cursokotlin.Units.Unit41

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Project169(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    var documentoInput by remember { mutableStateOf("") }
    var resultMessage by remember { mutableStateOf("") }
    val curso1 = remember { Curso() }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Student Registration Check",
            style = MaterialTheme.typography.headlineMedium
        )

        // Input field for student ID
        TextField(
            value = documentoInput,
            onValueChange = { documentoInput = it },
            label = { Text("Enter Student ID") },
            keyboardOptions = androidx.compose.foundation.text.KeyboardOptions(
                keyboardType = androidx.compose.ui.text.input.KeyboardType.Number
            )
        )

        // Check button
        Button(
            onClick = {
                val documento = documentoInput.toIntOrNull()
                if (documento != null) {
                    resultMessage = if (documento in curso1) {
                        "The student is registered in the course"
                    } else {
                        "The student is not registered in the course"
                    }
                } else {
                    resultMessage = "Please enter a valid student ID"
                }
            }
        ) {
            Text("Check Registration")
        }

        // Display result
        Text(
            text = resultMessage,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(top = 16.dp)
        )

        // Display list of registered students
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Registered Students:",
                    style = MaterialTheme.typography.titleMedium
                )
                curso1.alumnos.forEach { alumno ->
                    Text("${alumno.nombre} (ID: ${alumno.documento})")
                }
            }
        }
    }
}