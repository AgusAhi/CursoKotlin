package com.example.cursokotlin.Units.Unit46

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Project182(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    // Define the products map
    val products = mapOf(
        "potatoes" to 12.5f,
        "apples" to 26f,
        "pears" to 31f,
        "tangerines" to 15f,
        "grapefruits" to 28f
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Display all products
        Text("Product List:")
        products.forEach { (key, value) ->
            Text("$key has a price of $$value")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Display count of products over $20
        val countOver20 = products.count { it.value > 20 }
        Text("Number of products with price over $20: $countOver20")
    }
}

@Composable
private fun PrintProducts(products: Map<String, Float>) {
    products.forEach { (key, value) ->
        Text("$key has a price of $$value")
    }
}

@Composable
private fun ShowProductsOver20(products: Map<String, Float>) {
    val count = products.count { it.value > 20 }
    Text("Number of products with price over $20: $count")
}