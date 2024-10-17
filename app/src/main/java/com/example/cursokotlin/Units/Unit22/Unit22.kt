package com.example.cursokotlin.Units.Unit22

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
fun Unit22Title() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Unit 22",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontTittle,
            color = Color.Blue
        )
    }
}

@Composable
fun Unit22(modifier: Modifier = Modifier, navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        Unit22Title()

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = { navController.navigate("Project105") }) { Text("Go to Project 105") }
        Button(onClick = { navController.navigate("Project106") }) { Text("Go to Project 106") }
        Button(onClick = { navController.navigate("Project107") }) { Text("Go to Project 107") }
        Button(onClick = { navController.navigate("Project108") }) { Text("Go to Project 108") }
        Button(onClick = { navController.navigate("com/example/cursokotlin/Units") }) { Text("Go Back") }
    }
}
