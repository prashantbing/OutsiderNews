package com.multiplatformdemo.prashant

import com.multiplatform.di.domainModule
import org.koin.core.context.startKoin

actual class KoinInitializer {
    actual fun init() {
        startKoin {
            modules(domainModule, viewModelModule)
        }
    }
}