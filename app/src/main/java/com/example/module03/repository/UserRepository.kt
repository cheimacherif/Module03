package com.example.module03.repository

import androidx.lifecycle.LiveData
import com.example.module03.dao.UserDao
import com.example.module03.models.User

class UserRepository(private val userDao: UserDao) {
    //Le Repository agit comme une couche intermédiaire entre la source de données et le ViewMode
    val allUsers: LiveData<List<User>> = userDao.getAllUsers()
    suspend fun insert(user: User) {
        userDao.insert(user)
    }
    suspend fun delete(user: User) {
        userDao.deleteUser(user)
    }
}
