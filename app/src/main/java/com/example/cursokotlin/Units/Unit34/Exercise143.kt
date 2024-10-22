package com.example.cursokotlin.Units.Unit34

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

interface Shape {
    fun calculateArea(): Int
    fun calculatePerimeter(): Int
    fun resultTitle(): String {
        return "Shape Data"
    }
}

class Square(private val side: Int) : Shape {
    override fun calculateArea(): Int {
        return side * side
    }

    override fun calculatePerimeter(): Int {
        return side * 4
    }

    override fun resultTitle(): String {
        return "Square Data"
    }
}

class Rectangle(private val longSide: Int, private val shortSide: Int) : Shape {
    override fun calculateArea(): Int {
        return longSide * shortSide
    }

    override fun calculatePerimeter(): Int {
        return (longSide * 2) + (shortSide * 2)
    }

    override fun resultTitle(): String {
        return "Rectangle Data"
    }
}

@Composable
fun Project143(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    var squareData by remember { mutableStateOf<Triple<String, Int, Int>?>(null) }
    var rectangleData by remember { mutableStateOf<Triple<String, Int, Int>?>(null) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Button(
            onClick = {
                val square = Square(10)
                squareData = Triple(
                    square.resultTitle(),
                    square.calculatePerimeter(),
                    square.calculateArea()
                )
            }
        ) {
            Text("Calculate Square (side = 10)")
        }

        squareData?.let { (title, perimeter, area) ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(title)
                    Text("Square perimeter: $perimeter")
                    Text("Square area: $area")
                }
            }
        }

        Button(
            onClick = {
                val rectangle = Rectangle(10, 5)
                rectangleData = Triple(
                    rectangle.resultTitle(),
                    rectangle.calculatePerimeter(),
                    rectangle.calculateArea()
                )
            }
        ) {
            Text("Calculate Rectangle (10 x 5)")
        }

        rectangleData?.let { (title, perimeter, area) ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(title)
                    Text("Rectangle perimeter: $perimeter")
                    Text("Rectangle area: $area")
                }
            }
        }
    }
}