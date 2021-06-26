package com.eslammongy.onlinecourses.apiclient

import com.eslammongy.onlinecourses.model.CategoryModel
import com.eslammongy.onlinecourses.model.CourseModel
import retrofit2.Call
import retrofit2.http.GET

interface  ApiServices {

    @GET("category.json")
    fun getAllCategories():Call<List<CategoryModel>>

    @GET("course.json")
    fun getCourseContent(): Call<List<CourseModel>>
}