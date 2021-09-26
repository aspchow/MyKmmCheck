package com.example.mykmmcheck

import io.ktor.client.*
import io.ktor.client.engine.ios.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.Runnable
import platform.UIKit.UIDevice
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_main_queue
import platform.darwin.dispatch_queue_t
import kotlin.coroutines.CoroutineContext

internal actual val httpClient = HttpClient(Ios) {
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

internal actual val Main: CoroutineDispatcher =
    NsQueueDispatcher(dispatch_get_main_queue())

internal actual val Background: CoroutineDispatcher = Main


internal class NsQueueDispatcher(
    private val dispatchQueue: dispatch_queue_t
) : CoroutineDispatcher() {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        dispatch_async(dispatchQueue) {
            block.run()
        }
    }
}