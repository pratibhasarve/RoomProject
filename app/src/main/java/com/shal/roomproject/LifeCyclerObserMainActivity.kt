package com.shal.roomproject

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class LifeCyclerObserMainActivity: LifecycleObserver {

    val TAG = "ObserverMainActivity"
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStartListener(){
        Log.i(TAG, "Onstart of observer")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPauseListner(){
        Log.i(TAG, "OnPause of observer")
    }

}