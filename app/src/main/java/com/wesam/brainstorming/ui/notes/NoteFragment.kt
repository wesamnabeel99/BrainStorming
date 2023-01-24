package com.wesam.brainstorming.ui.notes

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.wesam.brainstorming.R
import com.wesam.brainstorming.databinding.FragmentNoteBinding
import com.wesam.brainstorming.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteFragment : BaseFragment<FragmentNoteBinding>(R.layout.fragment_note) {

    override val viewModel: NoteViewModel by viewModels()

    override fun onStart() {
        super.onStart()
        binding.imageView.setOnClickListener {
            findNavController().navigate(R.id.historyFragment)
        }
    }
}
