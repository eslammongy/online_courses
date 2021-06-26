package com.eslammongy.onlinecourses.model

import com.google.gson.annotations.SerializedName

data class PlayListModel(
    @SerializedName("name")
    private val name: String,

    @SerializedName("time")
    private val time: String,
)