package com.example.cursokotlin.Units.Unit46

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Project183(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    var englishWord by remember { mutableStateOf("") }
    var spanishWord by remember { mutableStateOf("") }
    var searchWord by remember { mutableStateOf("") }
    var searchResult by remember { mutableStateOf<String?>(null) }
    var showAddDialog by remember { mutableStateOf(false) }

    val dictionary = remember {
        mutableStateMapOf<String, String>()
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Add word button
        Button(
            onClick = { showAddDialog = true },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add New Word")
        }

        // Dictionary listing
        if (dictionary.isNotEmpty()) {
            Text("Dictionary Contents:", style = MaterialTheme.typography.titleMedium)
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.weight(1f)
            ) {
                items(dictionary.toList()) { (english, spanish) ->
                    Card(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(english)
                            Text("→")
                            Text(spanish)
                        }
                    }
                }
            }
        }

        // Search section
        OutlinedTextField(
            value = searchWord,
            onValueChange = { searchWord = it },
            label = { Text("Search English Word") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                searchResult = dictionary[searchWord]
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Search Translation")
        }

        // Search result
        searchResult?.let { result ->
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = if (result.isNotEmpty())
                        "Translation: $result"
                    else
                        "Word not found in dictionary",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }

    // Add word dialog
    if (showAddDialog) {
        AlertDialog(
            onDismissRequest = { showAddDialog = false },
            title = { Text("Add New Word") },
            text = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedTextField(
                        value = englishWord,
                        onValueChange = { englishWord = it },
                        label = { Text("English Word") }
                    )
                    OutlinedTextField(
                        value = spanishWord,
                        onValueChange = { spanishWord = it },
                        label = { Text("Spanish Word") }
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        if (englishWord.isNotEmpty() && spanishWord.isNotEmpty()) {
                            dictionary[englishWord] = spanishWord
                            englishWord = ""
                            spanishWord = ""
                            showAddDialog = false
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