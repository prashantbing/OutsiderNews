package com.multiplatformdemo.prashant

import com.multiplatformdemo.prashant.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

actual val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
}