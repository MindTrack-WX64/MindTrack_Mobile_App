package com.example.mindtrack_mobile_app.ui

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import com.example.mindtrack_mobile_app.R
import com.example.mindtrack_mobile_app.models.Patient
import com.example.mindtrack_mobile_app.repository.AppDatabase
import java.util.Calendar

class PatientActivity : AppCompatActivity() {
    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_patient)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "MindTrack.db"
        ).allowMainThreadQueries().build()

        val buttonUpload: Button = findViewById(R.id.btUpload)
        buttonUpload.setOnClickListener {
            addPatientToDatabase()
            finish()
        }
    }

    private fun showDatePickerDialog(editText: EditText) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _, selectedYear, selectedMonth, selectedDay ->
                val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                editText.setText(selectedDate)
            },
            year, month, day
        )
        datePickerDialog.show()
    }

    private fun addPatientToDatabase() {
        val fullName = findViewById<EditText>(R.id.etFullName).text.toString()
        val professionalId = findViewById<EditText>(R.id.etProfessionalId).text.toString().toInt()
        val phone = findViewById<EditText>(R.id.etPhone).text.toString()
        val email = findViewById<EditText>(R.id.etEmail).text.toString()
        val age = findViewById<EditText>(R.id.etAge).text.toString().toInt()

        val patient = Patient(
            professionalId = professionalId,
            fullName = fullName,
            phone = phone,
            email = email,
            age = age
        )

        database.getPatientDao().insertPatient(patient)
    }
}