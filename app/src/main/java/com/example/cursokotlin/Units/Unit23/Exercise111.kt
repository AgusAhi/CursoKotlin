package com.example.cursokotlin.Units.Unit23

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun Project111(navController: NavHostController) {
    var studentName by remember { mutableStateOf("") }
    var studentGrade by remember { mutableStateOf("") }
    // Changed to use mutableStateListOf instead of mutableStateOf(mutableListOf())
    var students = remember { mutableStateListOf<Student>() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedTextField(
            value = studentName,
            onValueChange = { studentName = it },
            label = { Text("Enter student's name") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = studentGrade,
            onValueChange = { studentGrade = it },
            label = { Text("Enter student's grade") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                val grade = studentGrade.toIntOrNull()
                if (studentName.isNotEmpty() && grade != null) {
                    students.add(Student(name = studentName, grade = grade))
                    studentName = ""
                    studentGrade = ""
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = studentName.isNotEmpty() && studentGrade.isNotEmpty()
        ) {
            Text("Add Student")
        }

        // Added spacing between list and inputs
        Spacer(modifier = Modifier.height(16.dp))

        // Enhanced the list display with better formatting
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(students) { student ->
                Text(
                    text = "Name: ${student.name}, Grade: ${student.grade}, Status: ${student.getStatus()}",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                )
            }
        }
    }
}

data class Student(var name: String, var grade: Int) {
    fun getStatus(): String {
        return if (grade >= 4) "REGULAR" else "NOT REGULAR"
    }
}