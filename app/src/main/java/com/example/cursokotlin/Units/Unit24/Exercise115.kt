package com.example.cursokotlin.Units.Unit24

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Project115(modifier: Modifier = Modifier, navController: NavHostController) {
    var name by remember { mutableStateOf("") } // Student's name input
    var grade by remember { mutableStateOf("") } // Grade input
    var resultStudent by remember { mutableStateOf<String?>(null) } // Display student's name and grade
    var resultState by remember { mutableStateOf<String?>(null) } // Display student's state (regular or not)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Enter the student's name and grade")

        // Input field for student's name
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Enter student's name") },
            modifier = Modifier.fillMaxWidth()
        )

        // Input field for student's grade
        OutlinedTextField(
            value = grade,
            onValueChange = { grade = it },
            label = { Text("Enter student's grade") },
            modifier = Modifier.fillMaxWidth()
        )

        // Button to display the student's details
        Button(
            onClick = {
                val grade = grade.toIntOrNull()
                if (grade != null && name.isNotEmpty()) {
                    val alumno = Alumno(name, grade)
                    resultStudent = alumno.imprimir()
                    resultState = alumno.mostrarEstado()
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = name.isNotEmpty() && grade.isNotEmpty()
        ) {
            Text("Submit")
        }

        // Display the result for the student
        resultStudent?.let { BasicText(it) }
        resultState?.let { BasicText(it) }
    }
}

// Alumno class with methods to print student details and check regular state
class Alumno(val n: String, val g: Int) {

    // Function to print student's name and grade
    fun imprimir(): String {
        return "Student: $n has the grade $g"
    }

    // Function to display if the student is regular
    fun mostrarEstado(): String {
        return if (g >= 4) {
            "$n state is REGULAR"
        } else {
            "$n isn't REGULAR"
        }
    }
}
