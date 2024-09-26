package com.example.mindtrack_mobile_app.adapters
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mindtrack_mobile_app.R
import com.example.mindtrack_mobile_app.models.Patient
import com.example.mindtrack_mobile_app.ui.PatientDetailActivity


class PatientAdapter(private val patients: List<Patient>) : RecyclerView.Adapter<PatientAdapter.PatientViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatientViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.patient_list_item, parent, false)
        return PatientViewHolder(view)
    }

    override fun onBindViewHolder(holder: PatientViewHolder, position: Int) {
        val patient = patients[position]
        holder.fullName.text = patient.fullName
        holder.age.text = patient.age.toString()
        holder.email.text = patient.email
        holder.phone.text = patient.phone

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, PatientDetailActivity::class.java)
            intent.putExtra("PATIENT_ID", patient.professionalId)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = patients.size

    class PatientViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val fullName: TextView = itemView.findViewById(R.id.fullName)
        val age: TextView = itemView.findViewById(R.id.age)
        val email: TextView = itemView.findViewById(R.id.email)
        val phone: TextView = itemView.findViewById(R.id.phone)
    }
}