package com.example.cursokotlin

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


@Composable
fun Unit5(modifier: Modifier = Modifier, navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Button(onClick = { navController.navigate("Project10") }) {
            Text("Go to Project 10")
        }
        Button(onClick = { navController.navigate("Project11") }) {
            Text("Go to Project 11")
        }
        Button(onClick = { navController.navigate("Project12") }) {
            Text("Go to Project 12")
        }
        Button(onClick = { navController.navigate("Project13") }) {
            Text("Go to Project 13")
        }
        Button(onClick = { navController.navigate("Project14") }) {
            Text("Go to Project 14")
        }
        Button(onClick = { navController.navigate("Unit5") }) {
            Text("Go to Unit 5")
        }
    }
}
