package com.el3asas.data.local.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class Converters {

    @TypeConverter
    fun listOfStringToString(data: List<String?>?): String = Gson().toJson(data)

    @TypeConverter
    fun stringToListOfString(string: String): List<String?>? {
        return Gson().fromJson(string, object : TypeToken<List<String?>?>() {}.type)
    }
}