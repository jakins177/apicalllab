package com.sample.chatgptapilab1.network


import com.sample.chatgptapilab1.model.Post
import com.sample.chatgptapilab1.model.jResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): Response<List<Post>>
}