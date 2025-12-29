package proyectoa.com.proyectoaejemploestado

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

enum class Screens() {
    EstadoLayout(),
    Explicacion()
}

@Composable
fun Main(
    navController : NavHostController = rememberNavController()
) {

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = proyectoa.com.proyectoaejemploestado.Screens.valueOf(
        backStackEntry?.destination?.route ?: proyectoa.com.proyectoaejemploestado.Screens.Explicacion.name
    )

    Scaffold (
        topBar = {
            MainTopBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() },
                navController = navController
            )
        }
    ) {
        innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screens.Explicacion.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screens.Explicacion.name) {
                Explicacion(navController)
            }
            composable(Screens.EstadoLayout.name) {
                EstadoLayout(navController)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar (
    currentScreen: proyectoa.com.proyectoaejemploestado.Screens,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit = {},
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    TopAppBar (
        actions = {
            IconButton(onClick = navigateUp) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = ""
                )
            }
        },
        title = {
            Text(
                text = "APP fea",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    )
}