package com.example.mindtrack_mobile_app.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Patient(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "professional_id")
    val professionalId: Int,

    @ColumnInfo(name = "full_name")
    val fullName: String,

    @ColumnInfo(name = "phone")
    val phone: String,

    @ColumnInfo(name = "email")
    val email: String,

    @ColumnInfo(name = "age")
    val age: Int

)