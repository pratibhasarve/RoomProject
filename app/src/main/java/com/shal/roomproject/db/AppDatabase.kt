package com.shal.roomproject.db

import android.app.Application
import androidx.room.*
import kotlinx.coroutines.internal.synchronized

@Database(entities = arrayOf(User::class), version = 1)
@TypeConverters(AddressConverter::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object{
        private var userDatabase: AppDatabase? = null

        fun getDatabase(application: Application): AppDatabase?{
            if(userDatabase == null){
                //synchronized(AppDatabase::class.java){
                    if(userDatabase == null){
                        userDatabase = Room.databaseBuilder(
                            application,
                            AppDatabase::class.java, "database-name"
                        ).build()
                   // }
                }
            }

            return userDatabase

        }
    }
}