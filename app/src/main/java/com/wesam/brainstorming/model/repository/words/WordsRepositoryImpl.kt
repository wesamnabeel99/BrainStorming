package com.wesam.brainstorming.model.repository.words

import com.wesam.brainstorming.model.remote.network.API
import com.wesam.brainstorming.model.remote.network.ApiWrapper

// TODO: convert to regular class and use HILT to inject the dependency
object WordsRepositoryImpl : WordsRepository {

    override suspend fun getRecommendedWord(word: String) =
        ApiWrapper.wrapWithFlow { API.apiService.getNextWord(word) }

}

