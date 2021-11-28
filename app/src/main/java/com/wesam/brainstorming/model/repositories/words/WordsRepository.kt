package com.wesam.brainstorming.model.repositories.words

import com.wesam.brainstorming.model.network.API
import com.wesam.brainstorming.model.network.ApiWrapper

object WordsRepository : WordsRepositoryImpl {

    override suspend fun getRecommendedWord(word: String) =
        ApiWrapper.wrapWithFlow { API.apiService.getNextWord(word) }

}

