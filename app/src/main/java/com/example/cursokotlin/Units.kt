import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Units(modifier: Modifier = Modifier, navController: NavHostController) {
    val units = (5..48).map { "Unit $it" }

    LazyVerticalGrid(
        columns = GridCells.Fixed(4), // 4 columnas
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(units) { unit ->
            Button(
                onClick = { navController.navigate(unit.replace(" ", "")) }, // Navegar a la unidad correspondiente
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(2f) // Asegura que el botón sea cuadrado
            ) {
                Text(
                    text = "$unit",
                    fontSize = 8.sp, // Ajusta el tamaño de la fuente aquí
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}
