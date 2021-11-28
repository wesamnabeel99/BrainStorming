package com.wesam.brainstorming.model.repositories.words

import com.wesam.brainstorming.model.domain.word.WordResponse
import com.wesam.brainstorming.model.network.State
import kotlinx.coroutines.flow.Flow

interface WordsRepositoryImpl {
    suspend fun getRecommendedWord(word:String) : Flow<State<WordResponse?>>
}