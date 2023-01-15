package com.wesam.brainstorming.ui.util

import android.view.View
import com.wesam.brainstorming.model.remote.network.State

fun <T> View.handleErrorState(state: State<T>?) = if (state is State.Error) {
    this.visibility = View.VISIBLE
} else {
    this.visibility = View.GONE
}

fun <T> View.handleLoadingState(state: State<T>?) = if (state is State.Loading) {
    this.visibility = View.VISIBLE
} else {
    this.visibility = View.GONE
}

fun <T> View.handleSuccessState(state: State<T>?) = if (state is State.Success) {
    this.visibility = View.VISIBLE
} else {
    this.visibility = View.GONE
}
