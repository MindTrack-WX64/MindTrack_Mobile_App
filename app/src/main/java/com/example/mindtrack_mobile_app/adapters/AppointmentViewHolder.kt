package com.example.mindtrack_mobile_app.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mindtrack_mobile_app.R
import com.example.mindtrack_mobile_app.models.Appointment

class AppointmentViewHolder(view: View):RecyclerView.ViewHolder(view) {

    var tvName = view.findViewById<TextView>(R.id.tvName)
    var tvDate = view.findViewById<TextView>(R.id.tvDate)
    var tvHour = view.findViewById<TextView>(R.id.tvHour)

    fun render(appointmentModel: Appointment){
        tvName.text=appointmentModel.patientName
        tvDate.text=appointmentModel.date
        tvHour.text=appointmentModel.hour
    }
}