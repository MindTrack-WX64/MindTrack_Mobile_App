package com.example.mindtrack_mobile_app.models

import androidx.room.Entity

@Entity
class User (
    val id: Int,
    val email: String,
    val password: String
)