package com.wesam.brainstorming.util

import android.os.SystemClock
import android.view.View
import android.widget.Chronometer
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.wesam.brainstorming.model.remote.network.State
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

@BindingAdapter(value = ["app:startChronometerOver"])
fun startChronometerOver(chronometer: Chronometer, isTyping:Boolean) {
    val zeroBaseLine = SystemClock.elapsedRealtime()
    chronometer.base = zeroBaseLine + Constants.FIVE_SECONDS
    if (isTyping) {
        chronometer.base = zeroBaseLine + Constants.FIVE_SECONDS
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
    if(numberOfWords.toInt() >= Constants.WORDS_GOAL) {
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
        chronometer.base = zeroBaseLine + Constants.FIVE_SECONDS
    }
}
@BindingAdapter(value = ["app:clearEditTextOnFail"])
fun clearEditTextOnFail (editText: EditText , chronometerSeconds: String) {
    if (chronometerSeconds.contains("−")) {
        editText.text.clear()
    }
}

