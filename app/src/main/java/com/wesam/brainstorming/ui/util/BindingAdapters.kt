package com.wesam.brainstorming.ui.util

import android.os.SystemClock
import android.view.View
import android.widget.Chronometer
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import com.wesam.brainstorming.model.remote.network.State
import androidx.recyclerview.widget.RecyclerView
import com.wesam.brainstorming.ui.base.BaseRecyclerAdapter


@BindingAdapter(value = ["app:showWhenLoading"])
fun <T> showWhenLoading(view: View, state: State<T>?) {
    view.isVisible = state is State.Loading
}

@BindingAdapter(value = ["app:showWhenError"])
fun <T> showWhenError(view: View, state: State<T>?) {
    view.isVisible = state is State.Error
}

@BindingAdapter(value = ["app:showWhenSuccess"])
fun <T> showWhenSuccess(view: View, state: State<T>?) {
    view.isVisible = state is State.Success
}

@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView, items: List<T>?) {
    (view.adapter as BaseRecyclerAdapter<T>?)?.setItems(items ?: emptyList())
}

@BindingAdapter(value = ["app:startChronometerOver"])
fun startChronometerOver(chronometer: Chronometer, isTyping:Boolean) {
    val zeroBaseLine = SystemClock.elapsedRealtime()
    chronometer.base = zeroBaseLine + Constants.MINIMUM_TIME
    if (isTyping) {
        chronometer.base = zeroBaseLine + Constants.MINIMUM_TIME
    } else {
        chronometer.start()
    }
}

@BindingAdapter(value=["app:numberOfWords"])
fun calculateWords(textView: TextView ,text: String) {
    textView.text = "${text.trim().split(" ").filter { it!="" }.size}"
}

@BindingAdapter(value = ["app:showWhenGoalIsAchieved"])
fun showWhenGoalIsAchieved (view: View, numberOfWords : String) {
    if(numberOfWords.toInt() >= Constants.MINIMUM_WORDS_THRESHOLD) {
        view.visibility =View.VISIBLE
    } else {
        view.visibility =View.GONE
    }
}


@BindingAdapter(value=["app:showWhenFail"])
fun showWhenFail(view: View, chronometerSeconds : String) {
    if (chronometerSeconds.contains("−")) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
}

@BindingAdapter(value = ["app:restartChronometerOnFail"])
fun restartChronometerOnFail(chronometer: Chronometer, chronometerSeconds : String) {
    if (chronometerSeconds.contains("−")) {
        chronometer.stop()
        val zeroBaseLine = SystemClock.elapsedRealtime()
        chronometer.base = zeroBaseLine + Constants.MINIMUM_TIME
    }
}
@BindingAdapter(value = ["app:clearEditTextOnFail"])
fun clearEditTextOnFail (editText: EditText , chronometerSeconds: String) {
    if (chronometerSeconds.contains("−")) {
        editText.text.clear()
    }
}

