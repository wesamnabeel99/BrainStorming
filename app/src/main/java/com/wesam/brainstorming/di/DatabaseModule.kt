package com.wesam.brainstorming.di

import android.content.Context
import androidx.room.Room
import com.wesam.brainstorming.model.local.database.NotesDao
import com.wesam.brainstorming.model.local.database.NotesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    private const val DATABASE_NAME = "NOTES_DATABASE"

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) : NotesDatabase {
        return Room.databaseBuilder(
            context,
            NotesDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Provides
    fun provideNotesDao(database: NotesDatabase): NotesDao = database.notesDao()


}