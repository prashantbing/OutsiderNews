package com.multiplatform.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.serialization.SerializationException
import com.multiplatform.utility.Result
import com.multiplatform.utility.Error
import com.multiplatform.utility.NetworkError

class NetworkClient ( val httpClient: HttpClient){

     suspend inline fun  <reified T>get(
        urlString: String,
        block: HttpRequestBuilder.() -> Unit = {}
    ): Result<T, Error> = parseNetworkResults<T>{
        httpClient.get { url(urlString); block() }

    }
    suspend inline fun  <reified T>post(
        urlString: String,
        block: HttpRequestBuilder.() -> Unit = {}
    ): Result<T, Error> = parseNetworkResults<T>{
        httpClient.post { url(urlString); block() }

    }

    suspend inline fun <reified T> parseNetworkResults(function: () -> HttpResponse): Result<T, Error> {
        val response = try {
            function()
        } catch (e: UnresolvedAddressException) {
            return Result.Error(NetworkError.NO_INTERNET)
        } catch (e: SerializationException) {
            return Result.Error(NetworkError.SERIALIZATION)
        }

        return when (response.status.value) {
            in 200..299 -> {
                val censoredText = response.body<T>()
                Result.Success(censoredText)
            }

            401 -> Result.Error(NetworkError.UNAUTHORIZED)
            409 -> Result.Error(NetworkError.CONFLICT)
            408 -> Result.Error(NetworkError.REQUEST_TIMEOUT)
            413 -> Result.Error(NetworkError.PAYLOAD_TOO_LARGE)
            in 500..599 -> Result.Error(NetworkError.SERVER_ERROR)
            else -> Result.Error(NetworkError.UNKNOWN)
        }
    }

}



