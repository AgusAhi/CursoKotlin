package com.example.cursokotlin.Units.Unit6

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
fun Unit6Title() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Unit 6",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontTittle,
            color = Color.Blue
        )
    }
}

@Composable
fun Unit6(modifier: Modifier = Modifier, navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        Unit6Title()

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = { navController.navigate("Project15") }) { Text("Go to Project 15") }
        Button(onClick = { navController.navigate("Project16") }) { Text("Go to Project 16") }
        Button(onClick = { navController.navigate("Project17") }) { Text("Go to Project 17") }
        Button(onClick = { navController.navigate("com/example/cursokotlin/Units") }) { Text("Go Back") }
    }
}
