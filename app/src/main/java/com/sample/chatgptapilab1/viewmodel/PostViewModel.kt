package com.sample.chatgptapilab1.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.chatgptapilab1.model.Post
import com.sample.chatgptapilab1.network.RetrofitInstance
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {
    private val _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>> = _posts
    private  val TAG = "PostViewModel"

    fun fetchPosts() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.jshApi.gptRetrofitService.getPosts()
                if (response.isSuccessful) {

                    Log.i(TAG, "fetchPosts: success the response body is ${response.body()}")

                    val jResponse = response.body()
                    if (jResponse != null) {
                        _posts.value = jResponse
                        Log.i(TAG, "fetchPosts: post.value is ${_posts.value}")
                    }
                }
            } catch (e: Exception) {
                // Handle error
                Log.i(TAG, "fetchPosts error: ${e.message} ")
            }
        }
    }
}