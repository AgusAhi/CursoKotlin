package com.example.cursokotlin.Units.Unit9

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
fun Project35(modifier: Modifier = Modifier, navController: NavHostController) {
    var x by remember { mutableStateOf(0) }
    var grade by remember { mutableStateOf("") }
    var counter1 by remember { mutableStateOf(0) }
    var counter2 by remember { mutableStateOf(0) }
    var result1 by remember { mutableStateOf(0) }
    var result2 by remember { mutableStateOf(0) }
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = grade,
            onValueChange = { grade = it },
            label = { Text("Enter grade") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true,
        )

        Button(
            onClick = {
                val g = grade.toInt()
                if (g >= 7) {
                    counter1 += 1
                } else {
                    counter2 += 1
                }

                if (counter1 + counter2 == 10) {
                    result1 = counter1
                    result2 = counter2
                }

                x += 1
                grade = ""
            },
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Submit grade $x/10")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "The number of grades above 7 is: $result1 " +
                    "and the number of grades below 7 is: $result2",
            modifier = Modifier.padding(10.dp)
        )
    }
}
