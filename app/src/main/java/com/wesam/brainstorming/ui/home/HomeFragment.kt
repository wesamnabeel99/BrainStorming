package com.wesam.brainstorming.ui.home

import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.findNavController
import com.wesam.brainstorming.R
import com.wesam.brainstorming.databinding.FragmentHomeBinding
import com.wesam.brainstorming.ui.base.BaseFragment


class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    override val layoutId = R.layout.fragment_home
    override val viewModelClass = HomeViewModel::class.java

    override fun onStart() {
        super.onStart()
        binding.navigateButton.setOnClickListener {
            findNavController().navigate(R.id.historyFragment)
        }
        binding.editText.doOnTextChanged { text, _, _, _ ->
            viewModel.request(text.toString())
        }

        binding.addButton.setOnClickListener {
            viewModel.addNote(binding.editText.text.toString())
        }
        }


}