package com.wesam.brainstorming.model.repositories.notes

import com.wesam.brainstorming.model.entities.Note
import kotlinx.coroutines.flow.Flow

interface NotesRepositoryImpl {
    suspend fun insertNote(note: Note)
    suspend fun deleteNote(note: Note)
    fun getAllNotes() : Flow<List<Note>>
}