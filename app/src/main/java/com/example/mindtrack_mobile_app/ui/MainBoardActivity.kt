package com.example.mindtrack_mobile_app.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.mindtrack_mobile_app.R
import com.example.mindtrack_mobile_app.adapters.PatientAdapter
import com.example.mindtrack_mobile_app.repository.AppDatabase

class MainBoardActivity : AppCompatActivity() {
    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_board)

        // Initialize the database
        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "MindTrack.db"
        ).allowMainThreadQueries().build()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Get patients from the database
        val patients = database.getPatientDao().getAll()

        val adapter = PatientAdapter(patients)
        recyclerView.adapter = adapter

        val addPatientButton = findViewById<Button>(R.id.addPatientButton)
        addPatientButton.setOnClickListener {
            val intent = Intent(this, PatientActivity::class.java)
            startActivity(intent)
        }
    }
}