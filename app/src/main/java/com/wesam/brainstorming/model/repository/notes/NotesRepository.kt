package com.wesam.brainstorming.model.repository.notes

import com.wesam.brainstorming.model.local.entities.Note
import kotlinx.coroutines.flow.Flow

interface NotesRepository {
    suspend fun insertNote(note: Note)
    suspend fun deleteNote(note: Note)
    fun getAllNotes() : Flow<List<Note>>
}