package com.wesam.brainstorming.ui.home

import androidx.fragment.app.viewModels
import com.wesam.brainstorming.R
import com.wesam.brainstorming.databinding.FragmentHomeBinding
import com.wesam.brainstorming.ui.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    override val viewModel: HomeViewModel by viewModels()
}