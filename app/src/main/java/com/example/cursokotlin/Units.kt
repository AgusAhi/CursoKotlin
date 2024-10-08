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
        Button(onClick = { navController.navigate("Unit5") }) { Text("Go to Unit 5") }
        Button(onClick = { navController.navigate("Unit6") }) { Text("Go to Unit 6") }
        Button(onClick = { navController.navigate("Unit7") }) { Text("Go to Unit 7") }
        Button(onClick = { navController.navigate("Unit8") }) { Text("Go to Unit 8") }
        Button(onClick = { navController.navigate("Unit9") }) { Text("Go to Unit 9") }
        Button(onClick = { navController.navigate("Unit10") }) { Text("Go to Unit 10") }
        Button(onClick = { navController.navigate("Unit11") }) { Text("Go to Unit 11") }
        Button(onClick = { navController.navigate("Unit12") }) { Text("Go to Unit 12") }
        Button(onClick = { navController.navigate("Unit13") }) { Text("Go to Unit 13") }
        Button(onClick = { navController.navigate("Unit14") }) { Text("Go to Unit 14") }
        Button(onClick = { navController.navigate("Unit15") }) { Text("Go to Unit 15") }
        Button(onClick = { navController.navigate("Unit16") }) { Text("Go to Unit 16") }
        Button(onClick = { navController.navigate("Unit17") }) { Text("Go to Unit 17") }
        Button(onClick = { navController.navigate("Unit18") }) { Text("Go to Unit 18") }
        Button(onClick = { navController.navigate("Unit19") }) { Text("Go to Unit 19") }
        Button(onClick = { navController.navigate("Unit20") }) { Text("Go to Unit 20") }
        Button(onClick = { navController.navigate("Unit21") }) { Text("Go to Unit 21") }
        Button(onClick = { navController.navigate("Unit22") }) { Text("Go to Unit 22") }
        Button(onClick = { navController.navigate("Unit23") }) { Text("Go to Unit 23") }
        Button(onClick = { navController.navigate("Unit24") }) { Text("Go to Unit 24") }
        Button(onClick = { navController.navigate("Unit25") }) { Text("Go to Unit 25") }
        Button(onClick = { navController.navigate("Unit26") }) { Text("Go to Unit 26") }
        Button(onClick = { navController.navigate("Unit27") }) { Text("Go to Unit 27") }
        Button(onClick = { navController.navigate("Unit28") }) { Text("Go to Unit 28") }
        Button(onClick = { navController.navigate("Unit29") }) { Text("Go to Unit 29") }
        Button(onClick = { navController.navigate("Unit30") }) { Text("Go to Unit 30") }
        Button(onClick = { navController.navigate("Unit31") }) { Text("Go to Unit 31") }
        Button(onClick = { navController.navigate("Unit32") }) { Text("Go to Unit 32") }
        Button(onClick = { navController.navigate("Unit33") }) { Text("Go to Unit 33") }
        Button(onClick = { navController.navigate("Unit34") }) { Text("Go to Unit 34") }
        Button(onClick = { navController.navigate("Unit35") }) { Text("Go to Unit 35") }
        Button(onClick = { navController.navigate("Unit36") }) { Text("Go to Unit 36") }
        Button(onClick = { navController.navigate("Unit37") }) { Text("Go to Unit 37") }
        Button(onClick = { navController.navigate("Unit38") }) { Text("Go to Unit 38") }
        Button(onClick = { navController.navigate("Unit39") }) { Text("Go to Unit 39") }
        Button(onClick = { navController.navigate("Unit40") }) { Text("Go to Unit 40") }
        Button(onClick = { navController.navigate("Unit41") }) { Text("Go to Unit 41") }
        Button(onClick = { navController.navigate("Unit42") }) { Text("Go to Unit 42") }
        Button(onClick = { navController.navigate("Unit43") }) { Text("Go to Unit 43") }
        Button(onClick = { navController.navigate("Unit44") }) { Text("Go to Unit 44") }
        Button(onClick = { navController.navigate("Unit45") }) { Text("Go to Unit 45") }
        Button(onClick = { navController.navigate("Unit46") }) { Text("Go to Unit 46") }
        Button(onClick = { navController.navigate("Unit47") }) { Text("Go to Unit 47") }
        Button(onClick = { navController.navigate("Unit48") }) { Text("Go to Unit 48") }
    }
}