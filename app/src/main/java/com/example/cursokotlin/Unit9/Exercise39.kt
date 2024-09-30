package com.example.cursokotlin.Unit9

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

class Exercise39 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project39(modifier = Modifier, navController = rememberNavController())
        }
    }
}

@Composable
fun Project39(modifier: Modifier = Modifier, navController: NavHostController) {
    var x by remember { mutableStateOf(0) }
    var mult8 by remember { mutableStateOf(8) }
    var result1 by remember { mutableStateOf(0) }
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                if (mult8 <= 500) {
                    mult8 += 8
                }
                result1 = mult8
            },
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Next term")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "$mult8",
            modifier = Modifier.padding(10.dp)
        )
    }
}
