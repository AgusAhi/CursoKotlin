package com.example.cursokotlin.Unit5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
class Exercise14 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project14()
        }
    }
}
@Composable
fun Project14() {
    var number by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = number,
            onValueChange = { number = it },
            label = { Text("Enter a value between 1 and 99") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true,
        )
        Button(
            onClick = {
                var n1 = number.toInt()
                if (n1 < 10)
                    result = "It has one digit"
                else if (n1 < 100)
                    result = "It has two digits"
            },
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Confirmar")
        }
        Text(
            text = result,
            modifier = Modifier.padding(10.dp)
        )
    }
}
