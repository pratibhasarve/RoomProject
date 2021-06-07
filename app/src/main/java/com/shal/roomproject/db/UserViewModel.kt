package com.shal.roomproject.db

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application : Application): AndroidViewModel(application) {

    private val repositoryClass = RepositoryClass(application)
    val users = repositoryClass.users

    val userGender =  MutableLiveData<String>()

    init {
        userGender.postValue("Female")
    }

    fun insert(user : User){
        CoroutineScope(Dispatchers.IO).launch {
            repositoryClass.insert(user)
        }
    }
}