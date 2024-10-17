package com.example.cursokotlin.Units.Unit17

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
import com.example.cursokotlin.Units.Unit10.Unit10Title
import com.example.cursokotlin.ui.theme.FontTittle

@Composable
fun Unit17Title() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Unit 17",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontTittle,
            color = Color.Blue
        )
    }
}

@Composable
fun Unit17(modifier: Modifier = Modifier, navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        Unit17Title()

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = { navController.navigate("Project85") }) { Text("Go to Project 85") }
        Button(onClick = { navController.navigate("Project86") }) { Text("Go to Project 86") }
        Button(onClick = { navController.navigate("Project87") }) { Text("Go to Project 87") }
        Button(onClick = { navController.navigate("Project88") }) { Text("Go to Project 88") }
        Button(onClick = { navController.navigate("Project89") }) { Text("Go to Project 89") }
        Button(onClick = { navController.navigate("Project90") }) { Text("Go to Project 90") }
        Button(onClick = { navController.navigate("Project91") }) { Text("Go to Project 91") }
        Button(onClick = { navController.navigate("com/example/cursokotlin/Units") }) { Text("Go Back") }
    }
}
