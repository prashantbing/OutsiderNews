package com.multiplatformdemo.prashant

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.multiplatformdemo.prashant.home.Home
import com.multiplatformdemo.prashant.home.HomeViewModel
import com.multiplatformdemo.prashant.home.LatoTypography
import com.multiplatformdemo.prashant.home.textTopBar
import kmpdemo.composeapp.generated.resources.Res
import kmpdemo.composeapp.generated.resources.ic_navigation
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import org.koin.compose.currentKoinScope

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App() {
    MaterialTheme(      typography = LatoTypography(), colorScheme = colorScheme) {




        KoinContext {
            CompositionLocalProvider(LocalTextStyle provides
                    MaterialTheme.typography.displaySmall
            ) {
            val navController = rememberNavController()
                Scaffold(topBar = {

                    Surface(shadowElevation = 3.dp) {
                    CenterAlignedTopAppBar(
                        title = {

                           Text(style = textTopBar, text = "Outsider".toUpperCase(Locale.current ), textAlign = TextAlign.Center)

                        },
                        navigationIcon =  {

                            Icon(  painterResource( Res.drawable.ic_navigation), null, modifier = Modifier.fillMaxHeight().padding(start = 16.dp))

                        },
                        actions = {},
                    )
                    }                }) {
                    NavHost(modifier = Modifier.padding(it),
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
}

@Composable
inline fun <reified T: ViewModel> koinViewModel(): T {
    val scope = currentKoinScope()
    return viewModel {
        scope.get<T>()
    }
}