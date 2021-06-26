package com.eslammongy.onlinecourses.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CourseModel(
    @SerializedName("courseName")
    @Expose
    private val courseName: String,
    @SerializedName("rating")
    @Expose
    private val rating: String,
    @SerializedName("price")
    @Expose
    private val price: String,
    @SerializedName("bestSeller")
    @Expose
    private val bestSeller: String,
    @SerializedName("member")
    @Expose
    private val member: String,
    @SerializedName("playList")
    @Expose
    private val playList: List<PlayListModel>
)