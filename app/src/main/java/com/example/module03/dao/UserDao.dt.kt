package com.example.module03.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Delete
import androidx.room.Update
import com.example.module03.models.User

@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: User)
    @Query("SELECT * FROM user_table ORDER BY name ASC")
    fun getAllUsers(): LiveData<List<User>>
    @Delete
    suspend fun deleteUser(user: User)

    // Nouvelle méthode pour mettre à jour un utilisateur
    @Update
    suspend fun updateUser(user: User)
}