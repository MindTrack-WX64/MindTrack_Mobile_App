package com.example.mindtrack_mobile_app.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.mindtrack_mobile_app.R
import com.example.mindtrack_mobile_app.repository.AppDatabase

class PatientDetailActivity : AppCompatActivity() {
    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patient_detail)

        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "MindTrack.db"
        ).allowMainThreadQueries().build()

        val patientId = intent.getIntExtra("PATIENT_ID", -1)
        val patient = database.getPatientDao().getPatientById(patientId)

        findViewById<TextView>(R.id.fullName).text = patient?.fullName ?: "N/A"
        findViewById<TextView>(R.id.age).text = patient?.age?.toString() ?: "N/A"
        findViewById<TextView>(R.id.email).text = patient?.email ?: "N/A"
        findViewById<TextView>(R.id.phone).text = patient?.phone ?: "N/A"
    }
}