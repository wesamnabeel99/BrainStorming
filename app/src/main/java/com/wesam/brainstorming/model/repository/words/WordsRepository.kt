package com.wesam.brainstorming.model.repository.words

import com.wesam.brainstorming.model.remote.response.WordResponse
import com.wesam.brainstorming.model.remote.network.State
import kotlinx.coroutines.flow.Flow

interface WordsRepository {
    suspend fun getRecommendedWord(word:String) : Flow<State<WordResponse?>>
}