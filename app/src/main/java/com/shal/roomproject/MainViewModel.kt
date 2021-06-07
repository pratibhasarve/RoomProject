package com.shal.roomproject

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.properties.Delegates
import kotlin.random.Random

class MainViewModel : ViewModel() {

    val TAG = "MainViewModel"
    public val intRandom: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun createRandomNo(){
        intRandom.value = Random.nextInt().toString()
        Log.i(TAG, "Inside createRandomNo $intRandom.value")
    }

}