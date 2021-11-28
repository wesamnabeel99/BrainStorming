package com.wesam.brainstorming.ui.home

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.wesam.brainstorming.model.entities.Note
import com.wesam.brainstorming.model.domain.word.WordResponse
import com.wesam.brainstorming.model.network.State
import com.wesam.brainstorming.model.repositories.notes.NotesRepository
import com.wesam.brainstorming.model.repositories.words.WordsRepository
import com.wesam.brainstorming.ui.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect

import kotlinx.coroutines.launch
import java.util.*

class HomeViewModel : BaseViewModel() {


    val word = MutableStateFlow(State.Empty as State<WordResponse?>)

    fun request(text: String) {
        viewModelScope.launch {
            WordsRepository.getRecommendedWord(text).collect { response ->
                word.emit(response)

                response.toData()?.let {
                    if (it.size >= 1) {
                        Log.i("WWW", "$text --> " + it[0].word.toString())
                    } else {
                        Log.i("WWW", "$text --> " + "nothing")

                    }
                }
            }
        }
    }

    fun addNote(content: String) {
        viewModelScope.launch {
            NotesRepository.insertNote(Note(0, content, Calendar.getInstance().time))
        }
    }
}