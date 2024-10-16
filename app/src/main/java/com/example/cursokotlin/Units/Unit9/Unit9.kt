package com.example.cursokotlin.Units.Unit9

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.cursokotlin.Units.Unit5.Unit5Title
import com.example.cursokotlin.ui.theme.FontTittle

@Composable
fun Unit9Title() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Unit 9",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontTittle,
            color = Color.Blue
        )
    }
}

@Composable
fun Unit9(modifier: Modifier = Modifier, navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        Unit9Title()

        Spacer(modifier = Modifier.height(32.dp))

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
        Button(onClick = { navController.navigate("com/example/cursokotlin/Units") }) { Text("Go Back") }
    }
}
