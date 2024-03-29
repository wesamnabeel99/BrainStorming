package com.wesam.brainstorming.model.remote.network

sealed class State<out T> {
    data class Success<T>(val data: T) : State<T>()
    data class Error(val message: String) : State<Nothing>()
    object Empty : State<Nothing>()
    object Loading : State<Nothing>()

    fun toData() : T? = if (this is Success) data else null
}