package com.wesam.brainstorming.model.repository.notes

import com.wesam.brainstorming.model.local.entities.Note
import com.wesam.brainstorming.model.local.database.NotesDatabase

object NotesRepositoryImpl : NotesRepository {
    private val notesDao = NotesDatabase.getInstanceWithoutContext().notesDao()

    override suspend fun insertNote(note: Note) {
        notesDao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        notesDao.deleteNote(note)
    }

    override fun getAllNotes() = notesDao.getAllNotes()
}