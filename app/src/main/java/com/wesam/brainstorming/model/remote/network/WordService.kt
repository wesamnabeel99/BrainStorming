package com.wesam.brainstorming.model.remote.network

import com.wesam.brainstorming.model.remote.response.WordResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WordService {
    @GET("words")
    suspend fun getNextWord(
        @Query("lc") firstWord: String,
        @Query("sp") secondWord : String ="*"
    ): Response<WordResponse?>

}