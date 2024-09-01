package com.multiplatformdemo.prashant

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val viewModelModule = module {
    factory { AppViewModel(get()) }
    singleOf(::AppViewModel)
}