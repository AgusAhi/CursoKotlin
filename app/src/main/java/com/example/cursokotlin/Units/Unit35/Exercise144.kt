package com.example.cursokotlin.Units.Unit35

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

class Person(val name: String, val age: Int) {
    fun print(): String {
        return "Name: $name Age: $age"
    }

    fun isAdult() = age >= 18
}

@Composable
fun Project144(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val people = remember {
        arrayOf(
            Person("Ana", 22),
            Person("Juan", 13),
            Person("Carlos", 6),
            Person("Maria", 72)
        )
    }

    var showAdultCount by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "People List",
            style = MaterialTheme.typography.headlineMedium
        )

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            LazyColumn(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(people) { person ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(person.print())
                        if (person.isAdult()) {
                            Badge(
                                containerColor = MaterialTheme.colorScheme.primary
                            ) {
                                Text("Adult", color = MaterialTheme.colorScheme.onPrimary)
                            }
                        }
                    }
                    Divider()
                }
            }
        }

        Button(
            onClick = { showAdultCount = true }
        ) {
            Text("Show Adult Count")
        }

        if (showAdultCount) {
            val adultCount = people.count { it.isAdult() }
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer
                )
            ) {
                Text(
                    text = "Number of adults: $adultCount",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}