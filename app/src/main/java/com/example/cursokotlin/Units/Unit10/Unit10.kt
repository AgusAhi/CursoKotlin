package com.example.cursokotlin.Units.Unit10

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
fun Unit10Title() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Unit 10",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontTittle,
            color = Color.Blue
        )
    }
}

@Composable
fun Unit10(modifier: Modifier = Modifier, navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        Unit10Title()

        Spacer(modifier = Modifier.height(32.dp))

        Button (onClick = { navController.navigate("Project42") }) { Text("Go to Project 42") }
        Button(onClick = { navController.navigate("Project43") }) { Text("Go to Project 43") }
        Button(onClick = { navController.navigate("Project44") }) { Text("Go to Project 44") }
        Button(onClick = { navController.navigate("Project45") }) { Text("Go to Project 45") }
        Button(onClick = { navController.navigate("Project46") }) { Text("Go to Project 46") }
        Button(onClick = { navController.navigate("com/example/cursokotlin/Units") }) { Text("Go Back") }
    }
}
