package com.example.cursokotlin.Units.Unit46

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

data class Product(
    val name: String,
    val price: Float,
    val quantity: Int
)

@Composable
fun Project184(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    var searchCode by remember { mutableStateOf("") }
    var searchResult by remember { mutableStateOf<Pair<Int, Product>?>(null) }

    val products = remember {
        mutableStateMapOf(
            1 to Product("Potatoes", 13.15f, 200),
            15 to Product("Apples", 20f, 0),
            20 to Product("Pears", 3.50f, 0)
        )
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Product List Section
        Text(
            "Complete Product List",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(products.toList()) { (code, product) ->
                ProductCard(code, product)
            }
        }

        // Out of Stock Count
        val outOfStockCount = products.count { it.value.quantity == 0 }
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer
            )
        ) {
            Text(
                "Products Out of Stock: $outOfStockCount",
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.titleMedium
            )
        }

        // Product Search Section
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    "Search Product",
                    style = MaterialTheme.typography.titleMedium
                )

                OutlinedTextField(
                    value = searchCode,
                    onValueChange = {
                        searchCode = it.filter { char -> char.isDigit() }
                    },
                    label = { Text("Enter Product Code") },
                    modifier = Modifier.fillMaxWidth()
                )

                Button(
                    onClick = {
                        searchCode.toIntOrNull()?.let { code ->
                            searchResult = products[code]?.let { product ->
                                code to product
                            }
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Search")
                }

                searchResult?.let { (code, product) ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer
                        )
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text("Code: $code")
                            Text("Name: ${product.name}")
                            Text("Price: $${product.price}")
                            Text("Stock: ${product.quantity}")
                        }
                    }
                } ?: if (searchCode.isNotEmpty()) {
                    Text(
                        "No product found with this code",
                        color = MaterialTheme.colorScheme.error
                    )
                } else {
                    Text("Please enter a product code")
                }
            }
        }
    }
}

@Composable
private fun ProductCard(
    code: Int,
    product: Product,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = if (product.quantity == 0)
                MaterialTheme.colorScheme.errorContainer
            else
                MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    "Code: $code",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(product.name)
            }
            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text("$${product.price}")
                Text(
                    "Stock: ${product.quantity}",
                    color = if (product.quantity == 0)
                        MaterialTheme.colorScheme.error
                    else
                        MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}