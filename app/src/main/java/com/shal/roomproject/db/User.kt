package com.shal.roomproject.db

import android.provider.Telephony
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(@PrimaryKey var uid: Int,
                @ColumnInfo(name = "first_name") var firstName: String?,
                @ColumnInfo(name = "last_name") var lastName: String?,
                @ColumnInfo(name = "addresses") var addresses: List<Address?>?
) {
}