package com.wesam.brainstorming.model.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.wesam.brainstorming.model.local.entities.Note


@Database(
    entities = [Note::class],
    version = 1,
)
@TypeConverters(Convertor::class)
abstract class NotesDatabase : RoomDatabase() {
    abstract fun notesDao(): NotesDao
}