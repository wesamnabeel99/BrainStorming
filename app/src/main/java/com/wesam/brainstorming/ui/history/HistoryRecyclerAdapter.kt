package com.wesam.brainstorming.ui.history

import com.wesam.brainstorming.R
import com.wesam.brainstorming.model.domain.Note
import com.wesam.brainstorming.ui.base.BaseRecyclerAdapter

class HistoryRecyclerAdapter(list: List<Note>,listener: HistoryInteractionListener) :
    BaseRecyclerAdapter<Note>(list, listener = listener) {
    override val layoutId: Int = R.layout.item_note

    override fun <T> areItemsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int,
        newItems: List<T>,
    ): Boolean {
      return newItems[newItemPosition] == newItems[oldItemPosition]
    }
}