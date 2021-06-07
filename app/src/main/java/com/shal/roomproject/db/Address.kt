package com.shal.roomproject.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class Address(
    @PrimaryKey val id: Int?,
    @ColumnInfo(name = "address_line1") val addLine1 : String?,
    @ColumnInfo(name = "address_line2") val addLine2: String?) {
}