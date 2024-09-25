package com.example.mindtrack_mobile_app.repository

import android.provider.ContactsContract.Contacts
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.mindtrack_mobile_app.models.User

@Dao
interface UserDao {
    //crud
    @Query("SELECT * FROM User")
    fun getAll(): List<User>

    @Insert
    fun insertUser(vararg user:User)

    @Delete
    fun deleteUser(vararg user:User)

    @Update
    fun updateUser(vararg user:User)
}