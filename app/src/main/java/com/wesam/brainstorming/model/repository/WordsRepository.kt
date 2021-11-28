package com.wesam.brainstorming.model.repository

import com.wesam.brainstorming.model.network.API
import com.wesam.brainstorming.model.network.ApiWrapper

object WordsRepository {

    suspend fun getRecommendedWord(word:String) = ApiWrapper.wrapWithFlow { API.apiService.getNextWord(word) }

}

