package com.example.cursokotlin.Units.Unit35

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import java.text.NumberFormat
import java.util.Locale

data class Article(
    val code: Int,
    val description: String,
    var price: Float
)

@Composable
fun Project145(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    var articles by remember {
        mutableStateOf(
            arrayOf(
                Article(1, "Potatoes", 7.5f),
                Article(2, "Apples", 23.2f),
                Article(3, "Oranges", 12f),
                Article(4, "Onions", 21f)
            )
        )
    }

    var pricesIncreased by remember { mutableStateOf(false) }

    val currencyFormat = remember {
        NumberFormat.getCurrencyInstance(Locale.US)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = if (pricesIncreased)
                "Prices with 10% Increase"
            else
                "Current Prices",
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center
        )

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            LazyColumn(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(articles) { article ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = article.description,
                                style = MaterialTheme.typography.titleMedium
                            )
                            Text(
                                text = "Code: ${article.code}",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                        Text(
                            text = currencyFormat.format(article.price),
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                    Divider()
                }
            }
        }

        Button(
            onClick = {
                articles = articles.map { article ->
                    article.copy(price = article.price + (article.price * 0.10f))
                }.toTypedArray()
                pricesIncreased = true
            },
            enabled = !pricesIncreased
        ) {
            Text("Increase Prices by 10%")
        }

        if (pricesIncreased) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer
                )
            ) {
                Text(
                    text = "Prices have been increased by 10%",
                    modifier = Modifier.padding(16.dp),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}