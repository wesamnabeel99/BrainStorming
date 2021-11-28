package com.wesam.brainstorming.ui.home

import androidx.navigation.fragment.findNavController
import com.wesam.brainstorming.R
import com.wesam.brainstorming.databinding.FragmentNoteBinding
import com.wesam.brainstorming.ui.base.BaseFragment


class NoteFragment : BaseFragment<FragmentNoteBinding, NoteViewModel>() {
    override val layoutId = R.layout.fragment_note
    override val viewModelClass = NoteViewModel::class.java

    override fun onStart() {
        super.onStart()
        binding.imageView.setOnClickListener {
            findNavController().navigate(R.id.historyFragment)
        }
    }


}
