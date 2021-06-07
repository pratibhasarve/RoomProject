package com.shal.roomproject.db

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class RepositoryClass(application: Application) {

    val users: LiveData<List<User>>
    private val userDao: UserDao

    init {
        val userDb = AppDatabase.getDatabase(application)
        userDao = userDb!!.userDao()
        users = userDao.getAllUsers()
    }

    suspend fun insert(user: User) {
        userDao.insert(user)
        //println("Delay starts")
        delay(1000)
        //println("Delay ends")
    }

}