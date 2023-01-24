package com.wesam.brainstorming.ui.notes

import androidx.lifecycle.viewModelScope
import com.wesam.brainstorming.model.local.entity.Note
import com.wesam.brainstorming.model.remote.network.State
import com.wesam.brainstorming.model.remote.response.WordResponse
import com.wesam.brainstorming.model.repository.notes.NotesRepository
import com.wesam.brainstorming.model.repository.words.WordsRepository
import com.wesam.brainstorming.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val notesRepository: NotesRepository,
    private val wordsRepository: WordsRepository,
) : BaseViewModel() {

    val isChronometerStopped = MutableStateFlow(true)
    val noteContent = MutableStateFlow("")
    val numberOfWords = MutableStateFlow("0")
    val chronometerTime = MutableStateFlow("00:10")
    val word = MutableStateFlow(State.Empty as State<WordResponse?>)

    fun addNote(content: String) {
        viewModelScope.launch {
            notesRepository.insertNote(Note(content = content))
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
            wordsRepository.getRecommendedWord(text).collect { response ->
                word.emit(response)
            }
        }
    }

}