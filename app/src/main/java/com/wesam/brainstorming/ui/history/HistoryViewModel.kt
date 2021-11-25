package com.wesam.brainstorming.ui.history

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.wesam.brainstorming.model.domain.Note
import com.wesam.brainstorming.model.repository.NotesRepository
import com.wesam.brainstorming.ui.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.util.*

class HistoryViewModel : BaseViewModel(),HistoryInteractionListener {
    val notes = MutableStateFlow(listOf(Note(0,"hello",Date(1252136326))))

    fun addNote() {
        viewModelScope.launch {
            notes.value.get(0).let { NotesRepository.insertNote(Note(0,"hello",Date(1252136326))) }
        }
    }

    fun loadNotes() {
        viewModelScope.launch {
            notes.emit(NotesRepository.getAllNotes())
        }
    }
}