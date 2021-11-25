package com.wesam.brainstorming.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.wesam.brainstorming.model.domain.word.WordResponse
import com.wesam.brainstorming.model.network.State
import com.wesam.brainstorming.model.repository.WordsRepository
import com.wesam.brainstorming.ui.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect

import kotlinx.coroutines.launch

class HomeViewModel : BaseViewModel() {

     fun request() {
        viewModelScope.launch {
            WordsRepository.getNextWord().collect {
                word.postValue(it)
                Log.i("WWW",it.toString())
            }
        }
    }
    val word = MutableLiveData<State<WordResponse?>>()

}