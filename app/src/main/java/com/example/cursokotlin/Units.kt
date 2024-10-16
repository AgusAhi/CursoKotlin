import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.cursokotlin.ui.theme.FontTittle

@Composable
fun Units(modifier: Modifier = Modifier, navController: NavHostController) {
    val units = (5..48).map { "Unit $it" }

    val colors = listOf(
        Color.Blue, Color.DarkGray
    )

    val colorfulTitle = buildAnnotatedString {
        val title = "Curso Kotlin"
        title.forEachIndexed { index, char ->
            val color = colors[index % colors.size] // Cambia de color en cada letra
            append(AnnotatedString("$char", spanStyle = SpanStyle(color = color)))
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = colorfulTitle,
            fontSize = 40.sp,
            fontFamily = FontTittle,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 16.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(3), 
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(units) { unit ->
                Button(
                    onClick = { navController.navigate(unit.replace(" ", "")) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(2f)
                ) {
                    Text(
                        text = "$unit",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal
                    )
                }
            }
        }
    }
}
