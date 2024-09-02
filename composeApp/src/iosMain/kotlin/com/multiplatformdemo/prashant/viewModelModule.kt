package com.multiplatformdemo.prashant

import com.multiplatformdemo.prashant.home.HomeViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val viewModelModule = module {
    factory { HomeViewModel(get()) }
    singleOf(::HomeViewModel)
}