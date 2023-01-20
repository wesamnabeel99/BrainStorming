package com.wesam.brainstorming.ui.history

import androidx.fragment.app.viewModels
import com.wesam.brainstorming.R
import com.wesam.brainstorming.databinding.FragmentHistoryBinding
import com.wesam.brainstorming.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryFragment : BaseFragment<FragmentHistoryBinding>(R.layout.fragment_history) {

    override val viewModel: HistoryViewModel by viewModels()

    override fun onStart() {
        super.onStart()

        viewModel.loadNotes()
        setAdapter()
    }

    private fun setAdapter() {
        binding.historyRecycler.adapter = HistoryRecyclerAdapter(emptyList(), viewModel)
    }
}