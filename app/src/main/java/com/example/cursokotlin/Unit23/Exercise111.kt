package com.example.cursokotlin.Unit23

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

class Project111 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project111(modifier = Modifier, navController = rememberNavController())
        }
    }
}

@Composable
fun Project111( modifier: Modifier, navController: NavHostController) {
    var studentName by remember { mutableStateOf("") } // For storing student's name
    var studentGrade by remember { mutableStateOf("") } // For storing student's grade
    var students by remember { mutableStateOf(mutableListOf<Student>()) } // List of students

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Input field for student's name
        OutlinedTextField(
            value = studentName,
            onValueChange = { studentName = it },
            label = { Text("Enter student's name") },
            modifier = Modifier.fillMaxWidth()
        )

        // Input field for student's grade
        OutlinedTextField(
            value = studentGrade,
            onValueChange = { studentGrade = it },
            label = { Text("Enter student's grade") },
            modifier = Modifier.fillMaxWidth()
        )

        // Button to add student
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

        // Display the list of students
        LazyColumn {
            items(students) { student ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Text("Student: ${student.name}")
                    Text("Grade: ${student.grade}")
                    Text("Status: ${student.getStatus()}")
                }
            }
        }
    }
}

// Student class with properties and functions
data class Student(var name: String, var grade: Int) {
    fun getStatus(): String {
        return if (grade >= 4) "REGULAR" else "NOT REGULAR"
    }
}
