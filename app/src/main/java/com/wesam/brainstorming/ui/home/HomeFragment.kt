package com.wesam.brainstorming.ui.home

import com.wesam.brainstorming.R
import com.wesam.brainstorming.databinding.FragmentHomeBinding
import com.wesam.brainstorming.ui.base.BaseFragment


class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    override val layoutId = R.layout.fragment_home
    override val viewModelClass = HomeViewModel::class.java



}
