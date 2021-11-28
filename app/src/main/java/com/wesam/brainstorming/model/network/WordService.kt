package com.wesam.brainstorming.model.network

import com.wesam.brainstorming.model.domain.word.WordResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WordService {
    @GET("words")
    suspend fun getNextWord(
        @Query("lc") firstWord: String,
        @Query("sp") secondWord : String ="*"
    ): Response<WordResponse?>

}