package com.example.cursokotlin.Units.Unit41

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

class TicTacToe {
    val board = IntArray(9)

    operator fun set(row: Int, column: Int, value: Int) {
        board[row * 3 + column] = value
    }

    operator fun get(row: Int, column: Int): Int {
        return board[row * 3 + column]
    }

    fun reset() {
        for (i in board.indices) {
            board[i] = 0
        }
    }
}

@Composable
fun Project166(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    var game by remember { mutableStateOf(TicTacToe()) }
    var currentPlayer by remember { mutableStateOf(1) }
    var moveHistory by remember { mutableStateOf(listOf<String>()) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Current Player: ${if(currentPlayer == 1) "X" else "O"}",
            style = MaterialTheme.typography.titleLarge
        )

        // Game board
        Card(
            modifier = Modifier
                .padding(8.dp)
                .aspectRatio(1f),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                for (row in 0..2) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        for (col in 0..2) {
                            Cell(
                                value = game[row, col],
                                onClick = {
                                    if (game[row, col] == 0) {
                                        game[row, col] = currentPlayer
                                        moveHistory = moveHistory + "Player ${if(currentPlayer == 1) "X" else "O"} placed at row $row, column $col"
                                        currentPlayer = if (currentPlayer == 1) 2 else 1
                                    }
                                }
                            )
                        }
                    }
                }
            }
        }

        // Move history
        if (moveHistory.isNotEmpty()) {
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        "Move History",
                        style = MaterialTheme.typography.titleMedium
                    )
                    moveHistory.forEach { move ->
                        Text(move)
                    }
                }
            }
        }

        // Controls
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = {
                    game = TicTacToe()
                    currentPlayer = 1
                    moveHistory = emptyList()
                }
            ) {
                Text("Reset Game")
            }

            // Demo button to recreate the example moves
            Button(
                onClick = {
                    game = TicTacToe().apply {
                        this[0, 0] = 1 // X
                        moveHistory = moveHistory + "Player X placed at row 0, column 0"
                        this[0, 2] = 2 // O
                        moveHistory = moveHistory + "Player O placed at row 0, column 2"
                        this[2, 0] = 1 // X
                        moveHistory = moveHistory + "Player X placed at row 2, column 0"
                        this[1, 2] = 2 // O
                        moveHistory = moveHistory + "Player O placed at row 1, column 2"
                        this[1, 0] = 1 // X
                        moveHistory = moveHistory + "Player X placed at row 1, column 0"
                    }
                    currentPlayer = if (moveHistory.size % 2 == 0) 1 else 2
                }
            ) {
                Text("Load Example")
            }
        }
    }
}

@Composable
private fun Cell(
    value: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(60.dp)
            .border(1.dp, Color.Gray, RoundedCornerShape(4.dp))
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = when(value) {
                1 -> "X"
                2 -> "O"
                else -> ""
            },
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center
        )
    }
}
