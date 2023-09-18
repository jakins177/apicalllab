package com.sample.chatgptapilab1.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.sample.chatgptapilab1.model.Post
import com.sample.chatgptapilab1.ui.theme.ChatgptAPILab1Theme
import com.sample.chatgptapilab1.viewmodel.PostViewModel
import androidx.compose.foundation.lazy.items

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelProvider(this).get(PostViewModel::class.java)

        setContent {
            val posts = viewModel.posts.value // Observe the LiveData

            LaunchedEffect(key1 = true) {
                viewModel.fetchPosts()
            }
            ChatgptAPILab1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    posts?.let { PostList(it) }
                }
            }
        }
    }
}


@Composable
fun PostList(posts: List<Post>) {
    LazyColumn {
        items(posts) { post ->
            Text(text = post.title, modifier = Modifier.padding(16.dp))
        }
    }
}


