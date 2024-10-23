package com.example.cursokotlin.Units.Unit40

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

class Vector1 {
    val array = IntArray(5)

    fun load() {
        for(i in array.indices) {
            array[i] = (Math.random() * 11 + 1).toInt()
        }
    }

    fun print(): String {
        return array.joinToString(" ")
    }

    operator fun plus(vector2: Vector1): Vector1 {
        val sum = Vector1()
        for(i in array.indices) {
            sum.array[i] = array[i] + vector2.array[i]
        }
        return sum
    }

    operator fun minus(vector2: Vector1): Vector1 {
        val subtraction = Vector1()
        for(i in array.indices) {
            subtraction.array[i] = array[i] - vector2.array[i]
        }
        return subtraction
    }

    operator fun times(vector2: Vector1): Vector1 {
        val product = Vector1()
        for(i in array.indices) {
            product.array[i] = array[i] * vector2.array[i]
        }
        return product
    }

    operator fun div(vector2: Vector1): Vector1 {
        val division = Vector1()
        for(i in array.indices) {
            division.array[i] = array[i] / vector2.array[i]
        }
        return division
    }
}

@Composable
fun Project162(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    var vector1 by remember { mutableStateOf(Vector1()) }
    var vector2 by remember { mutableStateOf(Vector1()) }
    var sumResult by remember { mutableStateOf<Vector1?>(null) }
    var subtractionResult by remember { mutableStateOf<Vector1?>(null) }
    var productResult by remember { mutableStateOf<Vector1?>(null) }
    var divisionResult by remember { mutableStateOf<Vector1?>(null) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Button(
            onClick = {
                vector1 = Vector1().apply { load() }
                vector2 = Vector1().apply { load() }
                sumResult = vector1 + vector2
                subtractionResult = vector1 - vector2
                productResult = vector1 * vector2
                divisionResult = vector1 / vector2
            }
        ) {
            Text("Generate Random Vectors and Calculate")
        }

        if (vector1.array.any { it != 0 }) {
            ResultCard(
                title = "Vector 1:",
                content = vector1.print()
            )

            ResultCard(
                title = "Vector 2:",
                content = vector2.print()
            )

            sumResult?.let {
                ResultCard(
                    title = "Sum of vectors:",
                    content = it.print()
                )
            }

            subtractionResult?.let {
                ResultCard(
                    title = "Subtraction of vectors:",
                    content = it.print()
                )
            }

            productResult?.let {
                ResultCard(
                    title = "Product of vectors:",
                    content = it.print()
                )
            }

            divisionResult?.let {
                ResultCard(
                    title = "Division of vectors:",
                    content = it.print()
                )
            }
        }
    }
}

@Composable
private fun ResultCard(
    title: String,
    content: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(title)
            Text(
                text = content,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}