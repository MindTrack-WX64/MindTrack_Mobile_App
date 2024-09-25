package com.example.mindtrack_mobile_app.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mindtrack_mobile_app.models.User


@Database(entities = arrayOf(User::class), version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun getDao():UserDao

    companion object{
        private var INSTANCE: AppDatabase?= null

        fun getInstance(context: Context): AppDatabase{
            if(INSTANCE ==null){
                INSTANCE = Room
                    .databaseBuilder(context, AppDatabase::class.java, "MindTrack.db")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE as AppDatabase
        }
    }
}