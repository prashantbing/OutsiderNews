package com.multiplatformdemo.prashant

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText

class Greeting {
    private val platform = getPlatform()
    private val client = HttpClient()
    suspend fun greet(): String {
        val response = client.get("https://ktor.io/docs/client-create-multiplatform-application.html#run")
        return response.bodyAsText()
    }
}