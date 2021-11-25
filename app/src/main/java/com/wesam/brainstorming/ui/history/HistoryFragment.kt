package com.wesam.brainstorming.ui.history

import com.wesam.brainstorming.R
import com.wesam.brainstorming.databinding.FragmentHistoryBinding
import com.wesam.brainstorming.ui.base.BaseFragment

class HistoryFragment : BaseFragment<FragmentHistoryBinding,HistoryViewModel>() {

    override fun onStart() {
        super.onStart()
        viewModel.addNote()
        viewModel.addNote()
        viewModel.loadNotes()
        binding.historyRecycler.adapter = HistoryRecyclerAdapter(emptyList(),viewModel)
    }

    override val layoutId = R.layout.fragment_history
    override val viewModelClass = HistoryViewModel::class.java
}