package com.example.cursokotlin.Units.Unit34

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

class Person(val name: String, val age: Int) {
    fun isAdult(fn: (Int) -> Boolean): Boolean {
        return fn(age)
    }
}

fun isAdultUSA(age: Int): Boolean = age >= 21
fun isAdultArgentina(age: Int): Boolean = age >= 18

data class CountryAgeRule(
    val name: String,
    val checkAge: (Int) -> Boolean,
    val minimumAge: Int
)

@Composable
fun Project148(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var verificationResults by remember { mutableStateOf<Map<String, Boolean>>(emptyMap()) }
    var error by remember { mutableStateOf("") }

    val countries = remember {
        listOf(
            CountryAgeRule("Argentina", ::isAdultArgentina, 18),
            CountryAgeRule("United States", ::isAdultUSA, 21)
        )
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Age Verification by Country",
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center
        )

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                OutlinedTextField(
                    value = name,
                    onValueChange = {
                        name = it
                        error = ""
                        verificationResults = emptyMap()
                    },
                    label = { Text("Name") },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = age,
                    onValueChange = {
                        age = it.filter { char -> char.isDigit() }
                        error = ""
                        verificationResults = emptyMap()
                    },
                    label = { Text("Age") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                )

                if (error.isNotEmpty()) {
                    Text(
                        text = error,
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                Button(
                    onClick = {
                        if (name.isBlank()) {
                            error = "Please enter a name"
                            return@Button
                        }

                        if (age.isBlank()) {
                            error = "Please enter an age"
                            return@Button
                        }

                        try {
                            val ageInt = age.toInt()
                            val person = Person(name, ageInt)
                            verificationResults = countries.associate {
                                it.name to person.isAdult(it.checkAge)
                            }
                            error = ""
                        } catch (e: NumberFormatException) {
                            error = "Invalid age format"
                            verificationResults = emptyMap()
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Verify Age")
                }
            }
        }

        if (verificationResults.isNotEmpty()) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = "Results for $name",
                        style = MaterialTheme.typography.titleMedium
                    )

                    countries.forEach { country ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                Text(
                                    text = country.name,
                                    style = MaterialTheme.typography.bodyLarge
                                )
                                Text(
                                    text = "Minimum age: ${country.minimumAge}",
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }

                            Card(
                                colors = CardDefaults.cardColors(
                                    containerColor = if (verificationResults[country.name] == true)
                                        MaterialTheme.colorScheme.primaryContainer
                                    else
                                        MaterialTheme.colorScheme.errorContainer
                                )
                            ) {
                                Text(
                                    text = if (verificationResults[country.name] == true)
                                        "Adult"
                                    else
                                        "Minor",
                                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                                    color = if (verificationResults[country.name] == true)
                                        MaterialTheme.colorScheme.onPrimaryContainer
                                    else
                                        MaterialTheme.colorScheme.onErrorContainer
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}