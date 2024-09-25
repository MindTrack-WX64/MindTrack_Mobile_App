package com.example.mindtrack_mobile_app.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User (
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo
    val email: String,

    @ColumnInfo
    val password: String
)