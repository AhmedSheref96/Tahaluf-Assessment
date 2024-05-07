package com.el3asas.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.el3asas.data.local.enities.UniversityEntity

@Dao
interface UniversitiesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(universityEntity: UniversityEntity)

    @Query("delete from universityentity")
    suspend fun deleteAll()

    @Query("select * from universityentity where country =:country")
    suspend fun getAll(country:String): List<UniversityEntity>

}