package com.wesam.brainstorming.model.util

import android.view.View
import androidx.databinding.BindingAdapter
import com.wesam.brainstorming.model.network.State
import androidx.recyclerview.widget.RecyclerView
import com.wesam.brainstorming.ui.base.BaseRecyclerAdapter


@BindingAdapter(value = ["app:showWhenLoading"])
fun <T> showWhenLoading(view: View, state: State<T>?) {
    view.handleLoadingState(state)
}

@BindingAdapter(value = ["app:showWhenError"])
fun <T> showWhenError(view: View, state: State<T>?) {
    view.handleErrorState(state)
}

@BindingAdapter(value = ["app:showWhenSuccess"])
fun <T> showWhenSuccess(view: View, state: State<T>?) {
    view.handleSuccessState(state)
}

@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView, items: List<T>?) {
    (view.adapter as BaseRecyclerAdapter<T>?)?.setItems(items ?: emptyList())
}