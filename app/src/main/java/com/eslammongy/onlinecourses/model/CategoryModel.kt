package com.eslammongy.onlinecourses.model

import com.google.gson.annotations.SerializedName

data class CategoryModel(
    @SerializedName("categoryId")
     var categoryId: String,
    @SerializedName("categoryName")
     var categoryName: String,
    @SerializedName("totalCourses")
     var totalCourses: String,
    @SerializedName("image")
     var image: String,
)