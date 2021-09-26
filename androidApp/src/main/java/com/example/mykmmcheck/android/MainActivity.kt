package com.example.mykmmcheck.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.mykmmcheck.model.Post
import com.example.mykmmcheck.repository.ApiUtility
import com.example.mykmmcheck.repository.Repository

class MainActivity : AppCompatActivity() {
    lateinit var repository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        repository = Repository(ApiUtility())

        setContent {
            val posts = remember { mutableStateListOf<Post>() }

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Button(onClick = {
                    repository.getPosts().collect { newPosts ->
                        posts.clear()
                        posts.addAll(newPosts)
                    }
                }) {
                    Text(text = "Download Posts")
                }

                LazyColumn(content = {
                    items(posts) {
                        Text(text = it.title)
                    }
                })
            }
        }

    }
}

