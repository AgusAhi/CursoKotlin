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
fun Unit9(modifier: Modifier = Modifier, navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { navController.navigate("Project31") }) { Text("Go to Project 31") }
        Button(onClick = { navController.navigate("Project32") }) { Text("Go to Project 32") }
        Button(onClick = { navController.navigate("Project33") }) { Text("Go to Project 33") }
        Button(onClick = { navController.navigate("Project34") }) { Text("Go to Project 34") }
        Button(onClick = { navController.navigate("Project35") }) { Text("Go to Project 35") }
        Button(onClick = { navController.navigate("Project36") }) { Text("Go to Project 36") }
        Button(onClick = { navController.navigate("Project37") }) { Text("Go to Project 37") }
        Button(onClick = { navController.navigate("Project38") }) { Text("Go to Project 38") }
        Button(onClick = { navController.navigate("Project39") }) { Text("Go to Project 39") }
        Button(onClick = { navController.navigate("Project40") }) { Text("Go to Project 40") }
        Button (onClick = { navController.navigate("Project41") }) { Text("Go to Project 41") }
        Button(onClick = { navController.navigate("Units") }) { Text("Go Back") }
    }
}
