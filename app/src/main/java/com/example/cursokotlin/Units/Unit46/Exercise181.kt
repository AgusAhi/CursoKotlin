package com.example.cursokotlin.Units.Unit46

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlin.math.sqrt

@Composable
fun Project181(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    var countries by remember {
        mutableStateOf(
            mapOf(
                "argentina" to 40_000_000,
                "spain" to 46_000_000,
                "uruguay" to 3_400_000
            )
        )
    }

    var searchCountry by remember { mutableStateOf("") }
    var showAddDialog by remember { mutableStateOf(false) }
    var newCountry by remember { mutableStateOf("") }
    var newPopulation by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Country Population Analysis",
            style = MaterialTheme.typography.headlineMedium
        )

        // Search and Add Section
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedTextField(
                    value = searchCountry,
                    onValueChange = { searchCountry = it.lowercase() },
                    label = { Text("Search country") },
                    modifier = Modifier.fillMaxWidth()
                )

                // Search Result
                if (searchCountry.isNotEmpty()) {
                    val population = countries[searchCountry]
                    Text(
                        text = if (population != null)
                            "${searchCountry.capitalize(Locale.current)} population: ${population.formatPopulation()}"
                        else
                            "${searchCountry.capitalize(Locale.current)} not found in database",
                        color = if (population != null) MaterialTheme.colorScheme.primary else Color.Red
                    )
                }

                Button(
                    onClick = { showAddDialog = true },
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text("Add Country")
                }
            }
        }

        // Statistics Card
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Statistics",
                    style = MaterialTheme.typography.titleMedium
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Total Countries")
                        Text(
                            countries.size.toString(),
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Total Population")
                        Text(
                            countries.values.sum().formatPopulation(),
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.secondary
                        )
                    }
                }

                // Population Distribution Visualization
                Canvas(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .padding(top = 16.dp)
                ) {
                    val total = countries.values.sum().toFloat()
                    var startAngle = 0f
                    val colors = listOf(
                        Color(0xFF6200EE),
                        Color(0xFF3700B3),
                        Color(0xFF03DAC5)
                    )

                    countries.values.forEachIndexed { index, population ->
                        val sweepAngle = 360f * (population / total)
                        drawArc(
                            color = colors[index % colors.size],
                            startAngle = startAngle,
                            sweepAngle = sweepAngle,
                            useCenter = true,
                            size = Size(size.width * 0.8f, size.width * 0.8f),
                            topLeft = Offset(size.width * 0.1f, size.height * 0.1f)
                        )
                        startAngle += sweepAngle
                    }
                }
            }
        }

        // Countries List
        Card(
            modifier = Modifier.weight(1f)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(countries.toList()) { (country, population) ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surfaceVariant
                        )
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(country.capitalize(Locale.current))
                            Text(
                                population.formatPopulation(),
                                style = MaterialTheme.typography.titleMedium
                            )
                        }
                    }
                }
            }
        }
    }

    // Add Country Dialog
    if (showAddDialog) {
        AlertDialog(
            onDismissRequest = { showAddDialog = false },
            title = { Text("Add New Country") },
            text = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedTextField(
                        value = newCountry,
                        onValueChange = { newCountry = it.lowercase() },
                        label = { Text("Country Name") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = newPopulation,
                        onValueChange = { newPopulation = it },
                        label = { Text("Population") },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        newPopulation.toIntOrNull()?.let { population ->
                            if (newCountry.isNotBlank() && population > 0) {
                                countries = countries + (newCountry to population)
                                newCountry = ""
                                newPopulation = ""
                                showAddDialog = false
                            }
                        }
                    }
                ) {
                    Text("Add")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { showAddDialog = false }
                ) {
                    Text("Cancel")
                }
            }
        )
    }
}

private fun Int.formatPopulation(): String {
    return when {
        this >= 1_000_000 -> String.format("%.1fM", this / 1_000_000.0)
        this >= 1_000 -> String.format("%.1fK", this / 1_000.0)
        else -> this.toString()
    }
}