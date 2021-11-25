package com.wesam.brainstorming.model.repository

import com.wesam.brainstorming.model.domain.Note
import com.wesam.brainstorming.model.local.database.NotesDao
import com.wesam.brainstorming.model.local.database.NotesDatabase

object NotesRepository {
    private val notesDao = NotesDatabase.getInstanceWithoutContext().notesDao()
    suspend fun insertNote(note: Note) {
        notesDao.insertNote(note)
    }

    suspend fun getAllNotes(): List<Note> {
        return notesDao.getAllNotes()
    }
}