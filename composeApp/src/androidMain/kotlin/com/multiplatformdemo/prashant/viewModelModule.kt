package com.multiplatformdemo.prashant

import androidx.lifecycle.viewmodel.compose.viewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

actual val viewModelModule = module {
    viewModel { AppViewModel(get()) }
}