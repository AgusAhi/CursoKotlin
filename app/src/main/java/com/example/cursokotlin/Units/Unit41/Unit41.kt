package com.example.cursokotlin.Units.Unit41

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
fun Unit41Title() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Unit 41",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontTittle,
            color = Color.Blue
        )
    }
}

@Composable
fun Unit41(modifier: Modifier = Modifier, navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        Unit41Title()

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = { navController.navigate("Project162") }) { Text("Go to Project 162") }
        Button(onClick = { navController.navigate("Project163") }) { Text("Go to Project 163") }
        Button(onClick = { navController.navigate("Project164") }) { Text("Go to Project 164") }
        Button(onClick = { navController.navigate("Project165") }) { Text("Go to Project 165") }
        Button(onClick = { navController.navigate("Project166") }) { Text("Go to Project 166") }
        Button(onClick = { navController.navigate("Project167") }) { Text("Go to Project 167") }
        Button(onClick = { navController.navigate("Project168") }) { Text("Go to Project 168") }
        Button(onClick = { navController.navigate("Project169") }) { Text("Go to Project 169") }

        Button(onClick = { navController.navigate("com/example/cursokotlin/Units") }) { Text("Go Back") }
    }
}
