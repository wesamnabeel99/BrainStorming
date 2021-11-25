package com.wesam.brainstorming.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wesam.brainstorming.R
import com.wesam.brainstorming.model.local.database.NotesDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        NotesDatabase.getInstance(applicationContext)
    }
}