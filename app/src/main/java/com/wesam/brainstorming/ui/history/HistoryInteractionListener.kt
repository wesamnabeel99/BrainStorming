package com.wesam.brainstorming.ui.history

import com.wesam.brainstorming.model.entities.Note
import com.wesam.brainstorming.ui.base.BaseInteractionListener

interface HistoryInteractionListener :BaseInteractionListener {
    fun onClickDelete(note: Note)
}