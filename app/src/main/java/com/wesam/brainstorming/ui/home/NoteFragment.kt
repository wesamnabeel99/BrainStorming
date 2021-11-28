package com.wesam.brainstorming.ui.home

import com.wesam.brainstorming.R
import com.wesam.brainstorming.databinding.FragmentNoteBinding
import com.wesam.brainstorming.ui.base.BaseFragment


class NoteFragment : BaseFragment<FragmentNoteBinding, NoteViewModel>() {
    override val layoutId = R.layout.fragment_note
    override val viewModelClass = NoteViewModel::class.java



}
