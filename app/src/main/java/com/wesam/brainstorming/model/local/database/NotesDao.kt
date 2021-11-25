package com.wesam.brainstorming.model.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.wesam.brainstorming.model.domain.Note

@Dao
interface NotesDao {

    @Insert
    suspend fun insertNote(note: Note)

    @Query("SELECT * FROM NOTES_TABLE ORDER BY date DESC")
    suspend fun getAllNotes() : List<Note>
}