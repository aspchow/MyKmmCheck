package com.example.mykmmcheck.repository

import com.example.mykmmcheck.Background
import com.example.mykmmcheck.CFlow
import com.example.mykmmcheck.asCFlow
import com.example.mykmmcheck.getFlow
import com.example.mykmmcheck.model.Post
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow

class Repository(private val apiUtility: ApiUtility) {
    lateinit var postsJob: Job
    fun getPosts(): CFlow<List<Post>> = getFlow<List<Post>> {
        emit(apiUtility.getPosts())
    }.asCFlow()

    fun stopPostJob() = postsJob.cancel()

    fun getFlowPosts(): CFlow<Int> {
        val stateFlow = MutableStateFlow(1)
        var i = 0
        postsJob = CoroutineScope(Background).launch {
            while (true) {
                delay(1000)
                stateFlow.value = ++i
            }
        }
        return stateFlow.asCFlow()
    }
}