package com.wesam.brainstorming.ui.home

import androidx.lifecycle.viewModelScope
import com.wesam.brainstorming.model.local.entities.Note
import com.wesam.brainstorming.model.remote.network.State
import com.wesam.brainstorming.model.remote.response.WordResponse
import com.wesam.brainstorming.model.repository.notes.NotesRepositoryImpl
import com.wesam.brainstorming.model.repository.words.WordsRepositoryImpl
import com.wesam.brainstorming.ui.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class NoteViewModel : BaseViewModel() {

    val isChronometerStopped = MutableStateFlow(true)
    val noteContent = MutableStateFlow("")
    val numberOfWords = MutableStateFlow("0")
    val chronometerTime = MutableStateFlow("00:10")
    val word = MutableStateFlow(State.Empty as State<WordResponse?>)

    fun addNote(content: String) {
        viewModelScope.launch {
            NotesRepositoryImpl.insertNote(Note(content = content))
        }
    }

    fun updateChronometerState() {
        viewModelScope.launch {
            if (isChronometerStopped.value) {
                isChronometerStopped.emit(false)
            } else {
                isChronometerStopped.emit(true)
            }
        }
    }


    fun request(text: String) {
        viewModelScope.launch {
            WordsRepositoryImpl.getRecommendedWord(text).collect { response ->
                word.emit(response)
            }
        }
    }

}