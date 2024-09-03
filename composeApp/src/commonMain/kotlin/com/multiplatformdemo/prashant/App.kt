package com.multiplatformdemo.prashant

import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.multiplatformdemo.prashant.home.Home
import com.multiplatformdemo.prashant.home.HomeViewModel
import com.multiplatformdemo.prashant.home.LatoTypography
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import org.koin.compose.currentKoinScope

@Composable
@Preview
fun App() {
    MaterialTheme(      typography = LatoTypography(),) {
        KoinContext {
            CompositionLocalProvider(LocalTextStyle provides
                    MaterialTheme.typography.displaySmall
            ) {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "screenA"
            ) {
                composable("screenA") {
                    val viewModel = koinViewModel<HomeViewModel>()
                    val state by viewModel.state.collectAsState()

                    Home(state.article)

                }
            }
            }
        }
    }
}

@Composable
inline fun <reified T: ViewModel> koinViewModel(): T {
    val scope = currentKoinScope()
    return viewModel {
        scope.get<T>()
    }
}