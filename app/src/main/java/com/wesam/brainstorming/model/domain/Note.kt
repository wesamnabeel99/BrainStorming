package com.wesam.brainstorming.model.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "NOTES_TABLE")
data class Note(
    @PrimaryKey(autoGenerate = true) val id : Long,
    val content : String,
    val date : Date,
)
