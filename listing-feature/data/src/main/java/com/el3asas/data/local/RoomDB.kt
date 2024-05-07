package com.el3asas.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.el3asas.data.local.converters.Converters
import com.el3asas.data.local.daos.UniversitiesDao
import com.el3asas.data.local.enities.UniversityEntity

@Database(entities = [UniversityEntity::class], version = 4, exportSchema = true)
@TypeConverters(Converters::class)
abstract class RoomDB : RoomDatabase() {

    abstract fun universitiesDao(): UniversitiesDao
}