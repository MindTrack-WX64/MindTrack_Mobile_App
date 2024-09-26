package com.example.mindtrack_mobile_app.UI

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mindtrack_mobile_app.R
import com.example.mindtrack_mobile_app.adapters.AppointmentAdapter
import com.example.mindtrack_mobile_app.models.Appointment
import com.example.mindtrack_mobile_app.models.AppointmentProvider

class CalendarAppointmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calendar_appointment)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initRecyclerView()
    }

    private fun initRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.rvAppointment)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter = AppointmentAdapter(AppointmentProvider.appointmentList)
    }
}