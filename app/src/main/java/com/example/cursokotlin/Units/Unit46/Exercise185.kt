package com.example.cursokotlin.Units.Unit46

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

data class Subject(
    val name: String,
    val grade: Int
)

@Composable
fun Project185(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    var showAddStudentDialog by remember { mutableStateOf(false) }
    var searchDni by remember { mutableStateOf("") }
    var currentDni by remember { mutableStateOf("") }
    var currentSubject by remember { mutableStateOf("") }
    var currentGrade by remember { mutableStateOf("") }
    var showAddSubjectDialog by remember { mutableStateOf(false) }

    val students = remember {
        mutableStateMapOf<Int, List<Subject>>()
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Top Bar with Add Student Button
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "Student Grades Management",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            FloatingActionButton(
                onClick = { showAddStudentDialog = true }
            ) {
                Icon(Icons.Default.Add, "Add Student")
            }
        }

        // Student List
        if (students.isNotEmpty()) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.weight(1f)
            ) {
                items(students.toList()) { (dni, subjects) ->
                    StudentCard(
                        dni = dni,
                        subjects = subjects,
                        onAddSubject = {
                            currentDni = dni.toString()
                            showAddSubjectDialog = true
                        }
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
                Text("No students added yet")
            }
        }

        // Search Section
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    "Search Student",
                    style = MaterialTheme.typography.titleMedium
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedTextField(
                        value = searchDni,
                        onValueChange = { searchDni = it.filter { char -> char.isDigit() } },
                        label = { Text("Enter DNI") },
                        modifier = Modifier.weight(1f)
                    )

                    IconButton(
                        onClick = {
                            searchDni.toIntOrNull()?.let { dni ->
                                if (dni !in students) {
                                    searchDni = ""
                                }
                            }
                        }
                    ) {
                        Icon(Icons.Default.Search, "Search")
                    }
                }

                // Search Results
                searchDni.toIntOrNull()?.let { dni ->
                    students[dni]?.let { subjects ->
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer
                            )
                        ) {
                            Column(
                                modifier = Modifier.padding(16.dp)
                            ) {
                                Text("Student DNI: $dni", fontWeight = FontWeight.Bold)
                                subjects.forEach { subject ->
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Text("${subject.name}: ${subject.grade}")
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    // Add Student Dialog
    if (showAddStudentDialog) {
        AlertDialog(
            onDismissRequest = { showAddStudentDialog = false },
            title = { Text("Add New Student") },
            text = {
                OutlinedTextField(
                    value = currentDni,
                    onValueChange = { currentDni = it.filter { char -> char.isDigit() } },
                    label = { Text("DNI") }
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        currentDni.toIntOrNull()?.let { dni ->
                            if (dni !in students) {
                                students[dni] = emptyList()
                                currentDni = ""
                                showAddStudentDialog = false
                            }
                        }
                    }
                ) {
                    Text("Add")
                }
            },
            dismissButton = {
                TextButton(onClick = { showAddStudentDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }

    // Add Subject Dialog
    if (showAddSubjectDialog) {
        AlertDialog(
            onDismissRequest = { showAddSubjectDialog = false },
            title = { Text("Add Subject") },
            text = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedTextField(
                        value = currentSubject,
                        onValueChange = { currentSubject = it },
                        label = { Text("Subject Name") }
                    )
                    OutlinedTextField(
                        value = currentGrade,
                        onValueChange = { currentGrade = it.filter { char -> char.isDigit() } },
                        label = { Text("Grade") }
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        currentDni.toIntOrNull()?.let { dni ->
                            currentGrade.toIntOrNull()?.let { grade ->
                                if (currentSubject.isNotEmpty() && grade in 0..10) {
                                    val currentSubjects = students[dni] ?: emptyList()
                                    students[dni] = currentSubjects + Subject(currentSubject, grade)
                                    currentSubject = ""
                                    currentGrade = ""
                                    showAddSubjectDialog = false
                                }
                            }
                        }
                    }
                ) {
                    Text("Add")
                }
            },
            dismissButton = {
                TextButton(onClick = { showAddSubjectDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }
}

@Composable
private fun StudentCard(
    dni: Int,
    subjects: List<Subject>,
    onAddSubject: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Student DNI: $dni",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                IconButton(onClick = onAddSubject) {
                    Icon(Icons.Default.Add, "Add Subject")
                }
            }

            if (subjects.isNotEmpty()) {
                subjects.forEach { subject ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(subject.name)
                        Text("Grade: ${subject.grade}")
                    }
                }
            } else {
                Text(
                    "No subjects added",
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}