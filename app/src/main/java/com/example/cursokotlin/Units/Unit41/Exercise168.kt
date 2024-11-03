package com.example.cursokotlin.Units.Unit41

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

data class Student(val documento: Int, val nombre: String)

class Course {
    val students = arrayOf(
        Student(123456, "Marcos"),
        Student(666666, "Ana"),
        Student(777777, "Luis")
    )

    operator fun contains(documento: Int): Boolean {
        return students.any { documento == it.documento }
    }
}

@Composable
fun Project168(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    var checkResult by remember { mutableStateOf("") }
    val course1 = remember { Course() }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                checkResult = if (123456 in course1) {
                    "The student Marcos is registered in the course"
                } else {
                    "The student Marcos is not registered in the course"
                }
            }
        ) {
            Text("Check if Marcos (123456) is registered")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(checkResult)
    }
}