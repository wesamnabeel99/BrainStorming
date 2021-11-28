package com.wesam.brainstorming.ui.history

import androidx.lifecycle.viewModelScope
import com.wesam.brainstorming.model.domain.Note
import com.wesam.brainstorming.model.repository.NotesRepository
import com.wesam.brainstorming.ui.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HistoryViewModel : BaseViewModel(),HistoryInteractionListener {
    val notes = MutableStateFlow(listOf<Note>())

    fun loadNotes() {
        viewModelScope.launch {
            NotesRepository.getAllNotes().collect {
                notes.emit(it)
            }
        }
    }
}