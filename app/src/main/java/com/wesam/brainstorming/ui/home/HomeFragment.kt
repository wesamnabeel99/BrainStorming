package com.wesam.brainstorming.ui.home

import android.view.View
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
        binding.addButton.setOnClickListener {
            if (viewModel.numberOfWords.value.toInt() >= 3) {
                it.visibility = View.VISIBLE
            } else {
                it.visibility = View.GONE
            }
        }

    }


}
