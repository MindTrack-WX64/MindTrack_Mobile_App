package com.example.mindtrack_mobile_app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mindtrack_mobile_app.R
import com.example.mindtrack_mobile_app.models.Patient

class PatientAdapter(private val patients: List<Patient>) : RecyclerView.Adapter<PatientAdapter.PatientViewHolder>() {

    class PatientViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val fullName: TextView = itemView.findViewById(R.id.fullName)
        val age: TextView = itemView.findViewById(R.id.age)
        val email: TextView = itemView.findViewById(R.id.email)
        val phone: TextView = itemView.findViewById(R.id.phone)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatientViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.patient_list_item, parent, false)
        return PatientViewHolder(view)
    }

    override fun onBindViewHolder(holder: PatientViewHolder, position: Int) {
        val patient = patients[position]
        holder.fullName.text = patient.fullName
        // Assuming age and email are part of the Patient model
        holder.age.text = "Age: ${patient.age}"
        holder.email.text = "Email: ${patient.email}"
        holder.phone.text = "Phone: ${patient.phone}"
    }

    override fun getItemCount() = patients.size
}