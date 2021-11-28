package com.wesam.brainstorming.model.repository

import com.wesam.brainstorming.model.domain.Note
import com.wesam.brainstorming.model.local.database.NotesDatabase

object NotesRepository {
    private val notesDao = NotesDatabase.getInstanceWithoutContext().notesDao()

    suspend fun insertNote(note: Note) {
        notesDao.insertNote(note)
    }

    suspend fun deleteNote(note: Note) {
        notesDao.deleteNote(note)
    }

    fun getAllNotes() = notesDao.getAllNotes()
}