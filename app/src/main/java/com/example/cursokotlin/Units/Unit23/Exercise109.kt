package com.example.cursokotlin.Units.Unit23

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

class Persona {
    var nombre: String = ""
    var edad: Int = 0

    fun inicializar(nombre: String, edad: Int) {
        this.nombre = nombre
        this.edad = edad
    }

    fun imprimir() {
        println("Nombre: $nombre y tiene una edad de $edad")
    }

    fun esMayorEdad() {
        if (edad >= 18)
            println("Es mayor de edad $nombre")
        else
            println("No es mayor de edad $nombre")
    }
}

@Composable
fun Project109(modifier: Modifier = Modifier, navController: NavHostController) {
    var nombrePersona by remember { mutableStateOf("") }
    var edadPersona by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Enter Persona details:")
        OutlinedTextField(
            value = nombrePersona,
            onValueChange = { nombrePersona = it },
            label = { Text("Enter name") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = edadPersona,
            onValueChange = { edadPersona = it },
            label = { Text("Enter age") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = {
                val age = edadPersona.toIntOrNull() ?: 0
                val persona = Persona().apply {
                    inicializar(nombrePersona, age)
                }
                persona.imprimir()
                persona.esMayorEdad()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Create Persona")
        }
    }
}
