package com.example.mykmmcheck

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

internal actual val Main: CoroutineDispatcher = Dispatchers.Main

internal actual val Background: CoroutineDispatcher = Dispatchers.Default

internal actual val httpClient: HttpClient = HttpClient(Android) {
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }

        install(JsonFeature) {
            val json = kotlinx.serialization.json.Json {
                isLenient = true
                ignoreUnknownKeys = true
            }
            serializer = KotlinxSerializer(json)
        }
    }