package com.example.cursokotlin.Units.Unit45

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Project173(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val list1: List<String> = listOf("monday", "tuesday", "wednesday", "thuerday",
        "friday", "saturday", "sunday")

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            Text(
                text = "Complete List:",
                style = MaterialTheme.typography.titleMedium
            )
            Text(text = list1.toString())

            Divider(modifier = Modifier.padding(vertical = 8.dp))
        }

        item {
            Text(
                text = "First Element (using index):",
                style = MaterialTheme.typography.titleMedium
            )
            Text(text = list1[0])

            Divider(modifier = Modifier.padding(vertical = 8.dp))
        }

        item {
            Text(
                text = "First Element (using first()):",
                style = MaterialTheme.typography.titleMedium
            )
            Text(text = list1.first())

            Divider(modifier = Modifier.padding(vertical = 8.dp))
        }

        item {
            Text(
                text = "Last Element (using last()):",
                style = MaterialTheme.typography.titleMedium
            )
            Text(text = list1.last())

            Divider(modifier = Modifier.padding(vertical = 8.dp))
        }

        item {
            Text(
                text = "Last Element (using size-1):",
                style = MaterialTheme.typography.titleMedium
            )
            Text(text = list1[list1.size-1])

            Divider(modifier = Modifier.padding(vertical = 8.dp))
        }

        item {
            Text(
                text = "List Size:",
                style = MaterialTheme.typography.titleMedium
            )
            Text(text = list1.size.toString())

            Divider(modifier = Modifier.padding(vertical = 8.dp))
        }

        item {
            Text(
                text = "Complete List Elements:",
                style = MaterialTheme.typography.titleMedium
            )
            Text(text = list1.joinToString(" "))

            Divider(modifier = Modifier.padding(vertical = 8.dp))
        }

        item {
            Text(
                text = "Elements with Positions:",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = list1.indices.joinToString(" ") { position ->
                    "[$position]${list1[position]}"
                }
            )
        }
    }
}