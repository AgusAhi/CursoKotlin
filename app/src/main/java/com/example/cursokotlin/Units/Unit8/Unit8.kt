package com.example.cursokotlin.Units.Unit8

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
fun Unit8Title() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Unit 8",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontTittle,
            color = Color.Blue
        )
    }
}

@Composable
fun Unit8(modifier: Modifier = Modifier, navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        Unit8Title()

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = { navController.navigate("Project23") }) { Text("Go to Project 23") }
        Button(onClick = { navController.navigate("Project24") }) { Text("Go to Project 24") }
        Button(onClick = { navController.navigate("Project25") }) { Text("Go to Project 25") }
        Button(onClick = { navController.navigate("Project26") }) { Text("Go to Project 26") }
        Button(onClick = { navController.navigate("Project27") }) { Text("Go to Project 27") }
        Button(onClick = { navController.navigate("Project28") }) { Text("Go to Project 28") }
        Button(onClick = { navController.navigate("Project29") }) { Text("Go to Project 29") }
        Button(onClick = { navController.navigate("Project30") }) { Text("Go to Project 30") }
        Button(onClick = { navController.navigate("com/example/cursokotlin/Units") }) { Text("Go Back") }
    }
}
