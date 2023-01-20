package com.wesam.brainstorming.model.repository.words

import com.wesam.brainstorming.model.remote.network.ApiWrapper
import com.wesam.brainstorming.model.remote.network.WordService
import javax.inject.Inject

class WordsRepositoryImpl @Inject constructor(
    private val apiService: WordService
) : WordsRepository {
    override suspend fun getRecommendedWord(word: String) =
        ApiWrapper.wrapWithFlow { apiService.getNextWord(word) }
}

