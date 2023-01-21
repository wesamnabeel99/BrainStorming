package com.wesam.brainstorming.model.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "NOTES_TABLE")
data class Note(
    @PrimaryKey(autoGenerate = true) val id : Long = 0,
    val content : String,
    val date : Date = Calendar.getInstance().time,
)
