package com.shal.roomproject.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class AddressConverter{

    @TypeConverter
    fun fromAddressList(countryLang: List<Address?>?): String? {
        val type = object : TypeToken<List<Address>>() {}.type
        return Gson().toJson(countryLang, type)
    }

    @TypeConverter
    fun toAddressList(countryLangString: String?): List<Address>? {
        val type = object : TypeToken<List<Address>>() {}.type
        return Gson().fromJson<List<Address>>(countryLangString, type)
    }
}
