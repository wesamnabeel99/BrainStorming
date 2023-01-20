package com.wesam.brainstorming.ui.history

import androidx.lifecycle.viewModelScope
import com.wesam.brainstorming.model.local.entities.Note
import com.wesam.brainstorming.model.repository.notes.NotesRepository
import com.wesam.brainstorming.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val notesRepository: NotesRepository,
) : BaseViewModel(), HistoryInteractionListener {
    val notes = MutableStateFlow(listOf<Note>())

    fun loadNotes() {
        viewModelScope.launch {
            notesRepository.getAllNotes().collect {
                notes.emit(it)
            }
        }
    }

    override fun onClickDelete(note: Note) {
        viewModelScope.launch {
            notesRepository.deleteNote(note)
        }
    }
}