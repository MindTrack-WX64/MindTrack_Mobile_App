package com.example.mindtrack_mobile_app.ui
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mindtrack_mobile_app.R
import com.example.mindtrack_mobile_app.adapters.PatientAdapter
import com.example.mindtrack_mobile_app.models.Patient

class MainBoardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_board)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Example data
        val patients = listOf(
            Patient(1, 1, "John Doe", "123456789", "12344@hotmail.com", 25),
            Patient(2, 1, "Jane Smith", "987654321", "123456@hotmail.com", 25)
        )

        val adapter = PatientAdapter(patients)
        recyclerView.adapter = adapter

        val addPatientButton = findViewById<Button>(R.id.addPatientButton)
        addPatientButton.setOnClickListener {
            val intent = Intent(this, AddPatientActivity::class.java)
            startActivity(intent)
        }
    }
}


