package com.wesam.brainstorming.di

import com.wesam.brainstorming.model.repository.notes.NotesRepository
import com.wesam.brainstorming.model.repository.notes.NotesRepositoryImpl
import com.wesam.brainstorming.model.repository.words.WordsRepository
import com.wesam.brainstorming.model.repository.words.WordsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {
    @ViewModelScoped
    @Binds
    abstract fun bindNotesRepository(
        notesRepositoryImpl: NotesRepositoryImpl
    ): NotesRepository

    @ViewModelScoped
    @Binds
    abstract fun bindWordsRepository(
        wordsRepositoryImpl: WordsRepositoryImpl
    ): WordsRepository
}