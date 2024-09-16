package com.example.cursokotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cursokotlin.Unit5.Project10
import com.example.cursokotlin.Unit5.Project11
import com.example.cursokotlin.Unit5.Project12
import com.example.cursokotlin.Unit5.Project13
import com.example.cursokotlin.Unit5.Project14
import com.example.cursokotlin.ui.theme.CursoKotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CursoKotlinTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(navController = navController,startDestination = "Unit5") {
                        composable("Unit5"){ Unit5(modifier = Modifier.padding(innerPadding), navController) }
                        composable("Project10"){ Project10(modifier = Modifier.padding(innerPadding), navController) }
                        composable("Project11"){ Project11(modifier = Modifier.padding(innerPadding), navController) }
                        composable("Project12"){ Project12(modifier = Modifier.padding(innerPadding), navController) }
                        composable("Project13"){ Project13(modifier = Modifier.padding(innerPadding), navController) }
                        composable("Project14"){ Project14(modifier = Modifier.padding(innerPadding), navController) }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CursoKotlinTheme {
        Greeting("Android")
    }
}