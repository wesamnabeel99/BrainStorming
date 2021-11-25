package com.wesam.brainstorming.ui.note

import com.wesam.brainstorming.R
import com.wesam.brainstorming.databinding.FragmentHistoryBinding
import com.wesam.brainstorming.ui.base.BaseFragment

class NoteFragment : BaseFragment<FragmentHistoryBinding , NoteViewModel>() {
    override val layoutId = R.layout.fragment_note
    override val viewModelClass = NoteViewModel::class.java
}