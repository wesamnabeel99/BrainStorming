package com.wesam.brainstorming.model.repository.words

import com.wesam.brainstorming.model.remote.network.State
import com.wesam.brainstorming.model.remote.network.WordService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class WordsRepositoryImpl @Inject constructor(
    private val apiService: WordService,
) : WordsRepository {

    private fun <T> wrapWithFlow(function: suspend () -> Response<T>): Flow<State<T?>> = flow {
        emit(State.Loading)
        try {
            val result = function()
            if (result.isSuccessful) {
                emit(State.Success(result.body()))
            } else {
                emit(State.Error(result.message()))
            }
        } catch (e: Exception) {
            emit(State.Error(e.message.toString()))
        }
    }

    override suspend fun getRecommendedWord(word: String) =
        wrapWithFlow { apiService.getNextWord(word) }
}

