package com.example.cursokotlin.Units.Unit34

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

interface Point {
    fun print(): String
}

class PlanePoint(private val x: Int, private val y: Int) : Point {
    override fun print(): String {
        return "Point in plane: ($x,$y)"
    }
}

class SpacePoint(private val x: Int, private val y: Int, private val z: Int) : Point {
    override fun print(): String {
        return "Point in space: ($x,$y,$z)"
    }
}

@Composable
fun Project142(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    var planePointText by remember { mutableStateOf("") }
    var spacePointText by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Button(
            onClick = {
                val planePoint = PlanePoint(10, 4)
                planePointText = planePoint.print()
            }
        ) {
            Text("Show Plane Point")
        }

        if (planePointText.isNotEmpty()) {
            Text(text = planePointText)
        }

        Button(
            onClick = {
                val spacePoint = SpacePoint(20, 50, 60)
                spacePointText = spacePoint.print()
            }
        ) {
            Text("Show Space Point")
        }

        if (spacePointText.isNotEmpty()) {
            Text(text = spacePointText)
        }
    }
}