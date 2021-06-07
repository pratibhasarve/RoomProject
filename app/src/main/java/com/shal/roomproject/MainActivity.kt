package com.shal.roomproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.shal.roomproject.db.Address
import com.shal.roomproject.db.User
import com.shal.roomproject.db.UserViewModel
import java.util.EnumSet.of
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    //private lateinit var model: UserViewModel
     val model: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textview = findViewById<TextView>(R.id.textview)

        model.users.observe(this, Observer { users ->
            if(users.isNotEmpty()) {
                textview.text = users.size.toString()
                for(i in users){
                    Log.i(TAG, "User table ${i.uid}  ${i.firstName}")
                    Log.i(TAG, "Users address ${i.addresses?.get(0)?.addLine1}  " +
                            " ${i.addresses?.get(0)?.addLine2}")
                }
            }
        })

        val txtGender = findViewById<TextView>(R.id.txtGender)
        model.userGender.observe(this, Observer { gender ->
            if(gender != null){
                txtGender.text = gender
            }
        })

        this.lifecycle.addObserver(LifeCyclerObserMainActivity())
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "Onstart of Owner")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "OnPause of Owner")
    }

    fun changeRandomValue(view: View) {
        val uid = Random.nextInt()

        val listOfAddresses = mutableListOf<Address>()
        val singleAddress = Address(uid, "Balewadi", "Pune")
        val singleAddress2 = Address(uid-2, "Thrimurthi", "Nagpur")
        listOfAddresses.add(singleAddress)
        listOfAddresses.add(singleAddress2)

        val user = User(uid, "Pratibha", "Burde", listOfAddresses)
        model.insert(user)

        model.userGender.postValue("Male")
    }
}