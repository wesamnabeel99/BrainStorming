package com.wesam.brainstorming.model.network

import com.wesam.brainstorming.model.domain.word.WordResponse
import retrofit2.Response
import retrofit2.http.GET

interface WordService {
    @GET("words?lc=hello&sp=*")
    suspend fun getNextWord(
    ): Response<WordResponse?>

}