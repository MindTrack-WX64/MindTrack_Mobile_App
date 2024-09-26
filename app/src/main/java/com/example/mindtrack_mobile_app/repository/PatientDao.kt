package com.example.mindtrack_mobile_app.repository

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.mindtrack_mobile_app.models.Patient


@Dao
interface PatientDao {
    // CRUD
    @Query("SELECT * FROM Patient")
    fun getAll(): List<Patient>

    @Insert
    fun insertPatient(vararg patient: Patient)

    @Delete
    fun deletePatient(vararg patient: Patient)

    @Update
    fun updatePatient(vararg patient: Patient)

    @Query("SELECT * FROM Patient WHERE professional_id = :id")
    fun getPatientById(id: Int): Patient?
}