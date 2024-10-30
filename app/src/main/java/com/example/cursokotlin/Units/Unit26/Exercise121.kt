package com.example.cursokotlin.Units.Unit26

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.* // For layout management
import androidx.compose.material3.* // Material 3 for UI components
import androidx.compose.runtime.* // For managing state
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

// Composable function for the main UI
@Composable
fun Project121(modifier: Modifier = Modifier, navController: NavHostController) {
    val club = remember { Club() }
    var mostSeniority by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        Text(text = "Club Members", style = MaterialTheme.typography.titleLarge)

        // Display each member's name and seniority
        Text(text = "${club.member1.name} has been a member for ${club.member1.seniority} years.")
        Text(text = "${club.member2.name} has been a member for ${club.member2.seniority} years.")
        Text(text = "${club.member3.name} has been a member for ${club.member3.seniority} years.")

        // Button to evaluate and display the member with the most seniority
        Button(onClick = {
            mostSeniority = club.mostSeniority()
        }) {
            Text(text = "Find Member with Most Seniority")
        }

        if (mostSeniority.isNotEmpty()) {
            Text(text = "Member with most seniority: $mostSeniority")
        }
    }
}

// Data class representing a club member
class Member(val name: String, val seniority: Int)

// Class representing the club with multiple members
class Club {
    val member1 = Member("John", 22)
    val member2 = Member("Ana", 34)
    val member3 = Member("Carlos", 1)

    // Function to find and return the member with the most seniority
    fun mostSeniority(): String {
        return when {
            member1.seniority > member2.seniority && member1.seniority > member3.seniority -> member1.name
            member2.seniority > member3.seniority -> member2.name
            else -> member3.name
        }
    }
}
