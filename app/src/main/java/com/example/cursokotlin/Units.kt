package com.example.cursokotlin

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Units(modifier: Modifier = Modifier, navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { navController.navigate("Unit5") }) {
            Text("Go to Unit 5")
        }
        Button(onClick = { navController.navigate("Unit6") }) {
            Text("Go to Unit 6")
        }
        Button(onClick = { navController.navigate("Unit7") }) {
            Text("Go to Unit 7")
        }
        Button(onClick = { navController.navigate("Unit8") }) {
            Text("Go to Unit 8")
        }
        Button(onClick = { navController.navigate("Unit9") }) {
            Text("Go to Unit 9")
        }
        Button(onClick = { navController.navigate("Unit10") }) {
            Text("Go to Unit 10")
        }
    }
}