package com.wesam.brainstorming.model.local.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.wesam.brainstorming.model.local.entity.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDao {

    @Insert
    suspend fun insertNote(note: Note)

    @Query("SELECT * FROM NOTES_TABLE ORDER BY date DESC")
    fun getAllNotes(): Flow<List<Note>>

    @Delete
    suspend fun deleteNote(note: Note)
}