package com.example.mindtrack_mobile_app.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mindtrack_mobile_app.R
import com.example.mindtrack_mobile_app.models.Appointment

class AppointmentAdapter(private val appointmentList: List<Appointment>) : RecyclerView.Adapter<AppointmentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppointmentViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return AppointmentViewHolder(layoutInflater.inflate(R.layout.prototype_appoinment,parent,false))
    }

    override fun getItemCount(): Int {
        return appointmentList.size
    }

    override fun onBindViewHolder(holder: AppointmentViewHolder, position: Int) {
        val item = appointmentList[position]
        Log.i("prueba","$position")
        holder.render(item)
    }

}