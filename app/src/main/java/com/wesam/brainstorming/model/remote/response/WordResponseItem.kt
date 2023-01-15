package com.wesam.brainstorming.model.remote.response


import com.google.gson.annotations.SerializedName

data class WordResponseItem(
    @SerializedName("score")
    val score: Int? = null,
    @SerializedName("word")
    val word: String? = null
)