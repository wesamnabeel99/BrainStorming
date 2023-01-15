package com.wesam.brainstorming.model.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.wesam.brainstorming.model.local.entities.Note


@Database(entities = [Note::class], version = 1)
@TypeConverters(Convertor::class)
abstract class NotesDatabase : RoomDatabase() {
    abstract fun notesDao(): NotesDao

    companion object {
        @Volatile
        private var instance: NotesDatabase? = null

        fun getInstance(context: Context): NotesDatabase =
            instance ?: synchronized(this) { buildDatabase(context).also { instance = it } }

        fun getInstanceWithoutContext(): NotesDatabase {
            return instance!!
        }

        private const val DATABASE_NAME = "NotesDatabase"
        private fun buildDatabase(context: Context): NotesDatabase {
            return Room.databaseBuilder(context, NotesDatabase::class.java, DATABASE_NAME)
                .build()
        }
    }
}