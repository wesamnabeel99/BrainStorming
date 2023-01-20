package com.wesam.brainstorming.model.repository.notes

import com.wesam.brainstorming.model.local.database.NotesDao
import com.wesam.brainstorming.model.local.entities.Note
import com.wesam.brainstorming.model.local.database.NotesDatabase
import javax.inject.Inject


class NotesRepositoryImpl @Inject constructor(
    private val notesDao: NotesDao,
): NotesRepository {

    override suspend fun insertNote(note: Note) {
        notesDao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        notesDao.deleteNote(note)
    }

    override fun getAllNotes() = notesDao.getAllNotes()
}