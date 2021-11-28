package com.wesam.brainstorming.model.util

import android.os.SystemClock
import android.view.View
import android.widget.Chronometer
import android.widget.EditText
import android.widget.TextView
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

@BindingAdapter(value = ["app:startOver"])
fun startOver(chronometer: Chronometer , isTyping:Boolean) {
    val zeroBaseLine = SystemClock.elapsedRealtime()
    chronometer.base = zeroBaseLine + Constants.TEN_SECONDS
    if (isTyping) {
        chronometer.base = zeroBaseLine + Constants.TEN_SECONDS
    } else {
        chronometer.start()
    }
}

@BindingAdapter(value=["app:doOnZeroSecondsLeft"])
fun doOnZeroSecondsLeft(view: View,chronometerSeconds : String) {
    if (chronometerSeconds[Constants.FIRST_INDEX] == '-') {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
}

@BindingAdapter(value=["app:numberOfWords"])
fun calculateWords(textView: TextView ,text: String) {
    textView.text = "${text.trim().split(" ").filter { it!="" }.size}"
}

@BindingAdapter(value = ["app:showWhenGoalIsAchieved"])
fun showWhenGoalIsAchieved (view: View, text : String) {
    if(text == "3 Words") {
        view.visibility =View.VISIBLE
    } else {
        view.visibility =View.GONE
    }
}