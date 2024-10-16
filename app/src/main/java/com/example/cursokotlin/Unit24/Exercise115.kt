package com.example.cursokotlin.Unit24

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

class Project115 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project115( modifier = Modifier, navController = rememberNavController())
        }
    }
}

@Composable
fun Project115( modifier: Modifier, navController: NavHostController) {
    var nombre by remember { mutableStateOf("") } // Student's name input
    var nota by remember { mutableStateOf("") } // Grade input
    var resultAlumno by remember { mutableStateOf<String?>(null) } // Display student's name and grade
    var resultEstado by remember { mutableStateOf<String?>(null) } // Display student's state (regular or not)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Enter the student's name and grade")

        // Input field for student's name
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Enter student's name") },
            modifier = Modifier.fillMaxWidth()
        )

        // Input field for student's grade
        OutlinedTextField(
            value = nota,
            onValueChange = { nota = it },
            label = { Text("Enter student's grade") },
            modifier = Modifier.fillMaxWidth()
        )

        // Button to display the student's details
        Button(
            onClick = {
                val grade = nota.toIntOrNull()
                if (grade != null && nombre.isNotEmpty()) {
                    val alumno = Alumno(nombre, grade)
                    resultAlumno = alumno.imprimir()
                    resultEstado = alumno.mostrarEstado()
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = nombre.isNotEmpty() && nota.isNotEmpty()
        ) {
            Text("Submit")
        }

        // Display the result for the student
        resultAlumno?.let { BasicText(it) }
        resultEstado?.let { BasicText(it) }
    }
}

// Alumno class with methods to print student details and check regular state
class Alumno(val nombre: String, val nota: Int) {

    // Function to print student's name and grade
    fun imprimir(): String {
        return "Alumno: $nombre tiene una nota de $nota"
    }

    // Function to display if the student is regular
    fun mostrarEstado(): String {
        return if (nota >= 4) {
            "$nombre se encuentra en estado REGULAR"
        } else {
            "$nombre no está REGULAR"
        }
    }
}
