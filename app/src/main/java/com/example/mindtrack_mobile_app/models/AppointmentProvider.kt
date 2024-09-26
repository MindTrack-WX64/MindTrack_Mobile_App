package com.example.mindtrack_mobile_app.models

class AppointmentProvider {
    companion object{
        var appointmentList = listOf<Appointment>(
            Appointment("Miguel","10/12/24","10:00 AM"),
            Appointment("Angel","11/12/24","11:00 AM"),
            Appointment("Jose","14/11/24","09:00 AM")
        )
    }
}