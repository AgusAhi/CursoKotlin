package com.example.cursokotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cursokotlin.Unit5.*
import com.example.cursokotlin.Unit6.*
import com.example.cursokotlin.Unit7.*
import com.example.cursokotlin.Unit8.*
import com.example.cursokotlin.Unit9.*
import com.example.cursokotlin.ui.theme.CursoKotlinTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CursoKotlinTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()

                    // Un solo NavHost para todas las rutas
                    NavHost(
                        navController = navController,
                        startDestination = "Units", // Define una ruta inicial
                        modifier = Modifier.padding(innerPadding)
                    ) {

                        /*
                        composable("MenuPage") {
                            menuPage(navController = navController)
                        }
                        */

                        // Navegación para la pantalla de Units
                        composable("Units") {
                            Units(navController = navController)
                        }

                        // Navegación para Unit5 y sus ejercicios
                        composable("Unit5") {
                            Unit5(navController = navController)
                        }
                        composable("Project10") {
                            Project10(navController = navController)
                        }
                        composable("Project11") {
                            Project11(navController = navController)
                        }
                        composable("Project12") {
                            Project12(navController = navController)
                        }
                        composable("Project13") {
                            Project13(navController = navController)
                        }
                        composable("Project14") {
                            Project14(navController = navController)
                        }

                        // Navegación para Unit6 y sus ejercicios
                        composable("Unit6") {
                            Unit6(navController = navController)
                        }
                        composable("Project15") {
                            Project15(navController = navController)
                        }
                        composable("Project16") {
                            Project16(navController = navController)
                        }
                        composable("Project17") {
                            Project17(navController = navController)
                        }

                        // Navegación para Unit7 y sus ejercicios
                        composable("Unit7") {
                            Unit7(navController = navController)
                        }
                        composable("Project18") {
                            Project18(navController = navController)
                        }
                        composable("Project19") {
                            Project19(navController = navController)
                        }
                        composable("Project20") {
                            Project20(navController = navController)
                        }
                        composable("Project21") {
                            Project21(navController = navController)
                        }
                        composable("Project22") {
                            Project22(navController = navController)
                        }

                        // Navegación para Unit8 y sus ejercicios
                        composable("Unit8") {
                            Unit8(navController = navController)
                        }
                        composable("Project23") {
                            Project23(navController = navController)
                        }
                        composable ("Project24") {
                            Project24(navController = navController)
                        }
                        composable ("Project25") {
                            Project25(navController = navController)
                        }
                        composable ("Project26") {
                            Project26(navController = navController)
                        }
                        composable ("Project27") {
                            Project27(navController = navController)
                        }
                        composable ("Project28") {
                            Project28(navController = navController)
                        }
                        composable ("Project29") {
                            Project29(navController = navController)
                        }
                        composable ("Project30") {
                            Project30(navController = navController)
                        }

                        // Navegación para Unit9 y sus ejercicios
                        composable("Unit9") {
                            Unit9(navController = navController)
                        }
                        composable("Project31") {
                            Project31(navController = navController)
                        }
                        composable("Project32") {
                            Project32(navController = navController)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun menuPage(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xFFFFCDD2)) // Fondo de la página
            .wrapContentSize(Alignment.Center), // Alineación central del contenido
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Texto del título
        Text(
            text = "Curso Kotlin",
            modifier = modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center),
            color = Color(0xFFB71C1C),
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp)) // Espacio entre el título y los botones

        // Botón para ir a Unit 5
        Button(
            onClick = { navController.navigate("Unit5") },
            modifier = Modifier.padding(8.dp) // Padding entre los botones
        ) {
            Text(text = "Ir a Unit 5")
        }

        // Botón para ir a Unit 6
        Button(
            onClick = { navController.navigate("Unit6") },
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = "Ir a Unit 6")
        }

    }
}

