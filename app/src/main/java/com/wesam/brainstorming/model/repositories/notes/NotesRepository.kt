package com.wesam.brainstorming.model.repositories.notes

import com.wesam.brainstorming.model.entities.Note
import com.wesam.brainstorming.model.local.database.NotesDatabase

object NotesRepository : NotesRepositoryImpl {
    private val notesDao = NotesDatabase.getInstanceWithoutContext().notesDao()

    override suspend fun insertNote(note: Note) {
        notesDao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        notesDao.deleteNote(note)
    }

    override fun getAllNotes() = notesDao.getAllNotes()
}