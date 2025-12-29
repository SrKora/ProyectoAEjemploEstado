package proyectoa.com.proyectoaejemploestado

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun Explicacion(
    navController: NavHostController
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(145, 145, 145, 255)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("La siguiente aplicación se trata sobre calculadora de beneficios\n" +
                "DISFRUTALA =)")
        BotonNextPage(navController)
    }
}

@Composable
fun BotonNextPage(
    navController: NavHostController
) {
    Button(
        onClick = { navController.navigate(Screens.EstadoLayout.name)}
    ) {
        Text("Seguir")
    }
}

@Composable
@Preview
fun ExplicacionPreview() {
    val navController = rememberNavController()
    Explicacion(navController)
}