package com.eslammongy.onlinecourses.apiclient

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private const val baseUrl = "https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/course_app/"
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiServices:ApiServices by lazy { retrofit.create(ApiServices::class.java) }
}