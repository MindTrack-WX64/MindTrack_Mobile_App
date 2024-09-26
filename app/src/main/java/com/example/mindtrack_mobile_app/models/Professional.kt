package com.example.mindtrack_mobile_app.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
 class Professional(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "user_id")
    val userId: Int,

    @ColumnInfo(name = "full_name")
    val fullName: String,

    @ColumnInfo(name = "phone")
    val phone: String,

    @ColumnInfo(name = "patient_ids")
    val patientIds: List<Int>
)