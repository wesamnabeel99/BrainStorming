package com.wesam.brainstorming.ui.note

import androidx.lifecycle.viewModelScope
import com.wesam.brainstorming.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class NoteViewModel : BaseViewModel() {

    fun addNote() {
        viewModelScope.launch {
            //NotesRepository.insertNote(Note(0,"hello", Date(1252136326)))
        }
    }
}
