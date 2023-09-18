package com.sample.chatgptapilab1.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import okhttp3.OkHttpClient

object RetrofitInstance {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"


    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
    //vgames4life@yahoo.com
    //techforce
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()

//       private val retrofit = Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(MoshiConverterFactory.create())
//            .build()

    object jshApi {
        val gptRetrofitService : ApiService by lazy {
            retrofit.create(ApiService::class.java)
        }

    }
}