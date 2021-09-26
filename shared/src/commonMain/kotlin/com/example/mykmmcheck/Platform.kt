package com.example.mykmmcheck

import io.ktor.client.*
import io.ktor.utils.io.core.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

internal expect val Main: CoroutineDispatcher


internal expect val Background: CoroutineDispatcher

internal expect val httpClient: HttpClient


