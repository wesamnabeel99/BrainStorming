package com.wesam.brainstorming.model.remote.network

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



object ApiWrapper {
    fun <T> wrapWithFlow(function: suspend () -> Response<T>): Flow<State<T?>> = flow {
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
}




