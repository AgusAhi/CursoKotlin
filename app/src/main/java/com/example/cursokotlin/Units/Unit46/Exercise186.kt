package com.example.cursokotlin.Units.Unit46

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class Date(
    val day: Int,
    val month: Int,
    val year: Int
) {
    @RequiresApi(Build.VERSION_CODES.O)
    fun toLocalDate(): LocalDate = LocalDate.of(year, month, day)

    companion object {
        @RequiresApi(Build.VERSION_CODES.O)
        fun fromLocalDate(date: LocalDate): Date =
            Date(date.dayOfMonth, date.monthValue, date.year)
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Project186(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    var showAddActivityDialog by remember { mutableStateOf(false) }
    var selectedDate by remember { mutableStateOf<Date?>(null) }
    var currentActivity by remember { mutableStateOf("") }
    var searchDate by remember { mutableStateOf<Date?>(null) }

    val agenda = remember {
        mutableStateMapOf<Date, String>()
    }

    val dateFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy")

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Top Bar with Add Activity Button
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "Calendar Agenda",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            FloatingActionButton(
                onClick = {
                    selectedDate = Date.fromLocalDate(LocalDate.now())
                    showAddActivityDialog = true
                }
            ) {
                Icon(Icons.Default.Add, "Add Activity")
            }
        }

        // Activities List
        if (agenda.isNotEmpty()) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.weight(1f)
            ) {
                items(agenda.toList().sortedBy { it.first.toLocalDate() }) { (date, activity) ->
                    ActivityCard(
                        date = date,
                        activity = activity,
                        dateFormatter = dateFormatter
                    )
                }
            }
        } else {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text("No activities scheduled")
            }
        }

        // Search Section
        SearchSection(
            onSearch = { date -> searchDate = date },
            agenda = agenda,
            dateFormatter = dateFormatter
        )
    }

    // Add Activity Dialog
    if (showAddActivityDialog) {
        AddActivityDialog(
            initialDate = selectedDate,
            onDismiss = {
                showAddActivityDialog = false
                selectedDate = null
                currentActivity = ""
            },
            onConfirm = { date, activity ->
                agenda[date] = activity
                showAddActivityDialog = false
                selectedDate = null
                currentActivity = ""
            }
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
private fun ActivityCard(
    date: Date,
    activity: String,
    dateFormatter: DateTimeFormatter,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                date.toLocalDate().format(dateFormatter),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(activity)
        }
    }
}

@Composable
private fun SearchSection(
    onSearch: (Date) -> Unit,
    agenda: Map<Date, String>,
    dateFormatter: DateTimeFormatter
) {
    var day by remember { mutableStateOf("") }
    var month by remember { mutableStateOf("") }
    var year by remember { mutableStateOf("") }
    var searchResult by remember { mutableStateOf<String?>(null) }

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                "Search Activities",
                style = MaterialTheme.typography.titleMedium
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedTextField(
                    value = day,
                    onValueChange = { day = it.filter { char -> char.isDigit() } },
                    label = { Text("Day") },
                    modifier = Modifier.weight(1f)
                )
                OutlinedTextField(
                    value = month,
                    onValueChange = { month = it.filter { char -> char.isDigit() } },
                    label = { Text("Month") },
                    modifier = Modifier.weight(1f)
                )
                OutlinedTextField(
                    value = year,
                    onValueChange = { year = it.filter { char -> char.isDigit() } },
                    label = { Text("Year") },
                    modifier = Modifier.weight(1f)
                )
            }

            Button(
                onClick = {
                    val d = day.toIntOrNull()
                    val m = month.toIntOrNull()
                    val y = year.toIntOrNull()

                    if (d != null && m != null && y != null) {
                        try {
                            val date = Date(d, m, y)
                            searchResult = agenda[date]
                            onSearch(date)
                        } catch (e: Exception) {
                            searchResult = null
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Search")
            }

            searchResult?.let { activity ->
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    )
                ) {
                    Text(
                        activity,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            } ?: if (day.isNotEmpty() && month.isNotEmpty() && year.isNotEmpty()) {
                Text(
                    "No activities found for this date",
                    color = MaterialTheme.colorScheme.error
                )
            } else {
                Text("Enter a date")
            }
        }
    }
}

@Composable
private fun AddActivityDialog(
    initialDate: Date?,
    onDismiss: () -> Unit,
    onConfirm: (Date, String) -> Unit
) {
    var day by remember { mutableStateOf(initialDate?.day?.toString() ?: "") }
    var month by remember { mutableStateOf(initialDate?.month?.toString() ?: "") }
    var year by remember { mutableStateOf(initialDate?.year?.toString() ?: "") }
    var activity by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Add Activity") },
        text = {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedTextField(
                        value = day,
                        onValueChange = { day = it.filter { char -> char.isDigit() } },
                        label = { Text("Day") },
                        modifier = Modifier.weight(1f)
                    )
                    OutlinedTextField(
                        value = month,
                        onValueChange = { month = it.filter { char -> char.isDigit() } },
                        label = { Text("Month") },
                        modifier = Modifier.weight(1f)
                    )
                    OutlinedTextField(
                        value = year,
                        onValueChange = { year = it.filter { char -> char.isDigit() } },
                        label = { Text("Year") },
                        modifier = Modifier.weight(1f)
                    )
                }
                OutlinedTextField(
                    value = activity,
                    onValueChange = { activity = it },
                    label = { Text("Activity") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    val d = day.toIntOrNull()
                    val m = month.toIntOrNull()
                    val y = year.toIntOrNull()

                    if (d != null && m != null && y != null && activity.isNotEmpty()) {
                        try {
                            val date = Date(d, m, y)
                            onConfirm(date, activity)
                        } catch (e: Exception) {
                            // Invalid date
                        }
                    }
                }
            ) {
                Text("Add")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}