package com.multiplatform.data

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

object NetworkClientFactory {

    @OptIn(ExperimentalSerializationApi::class)
    val  networkClient =
        NetworkClient(HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    useAlternativeNames = false
                    explicitNulls = false
                    prettyPrint = true
                    isLenient = true
                })
            }
        })


}