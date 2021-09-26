package com.example.mykmmcheck.repository

import com.example.mykmmcheck.httpClient
import com.example.mykmmcheck.model.Post
import io.ktor.client.request.*
import io.ktor.http.*


class ApiUtility {
    suspend fun getPosts() = httpClient.request<List<Post>> {
        url("https://jsonplaceholder.typicode.com/posts")
        method = HttpMethod.Get
    }
}




