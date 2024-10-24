package com.example.cursokotlin.Units.Unit37

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
fun Unit37Title() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Unit 37",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontTittle,
            color = Color.Blue
        )
    }
}

@Composable
fun Unit37(modifier: Modifier = Modifier, navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        Unit37Title()

        Spacer(modifier = Modifier.height(32.dp))


        Button(onClick = { navController.navigate("Project149") }) { Text("Go to Project 149") }
        Button(onClick = { navController.navigate("Project150") }) { Text("Go to Project 150") }
        Button(onClick = { navController.navigate("Project150v2") }) { Text("Go to Project 150v2") }
        Button(onClick = { navController.navigate("Project151") }) { Text("Go to Project 151") }
        Button(onClick = { navController.navigate("com/example/cursokotlin/Units") }) { Text("Go Back") }
    }
}
