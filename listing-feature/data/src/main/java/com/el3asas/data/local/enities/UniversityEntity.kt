package com.el3asas.data.local.enities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.el3asas.domain.models.UniversityItem

@Entity
data class UniversityEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int?=null,
    val country: String? = null,
    val webPages: List<String?>? = null,
    val name: String? = null,
    val domains: List<String?>? = null,
    val stateProvince: String? = null,
    val alphaTwoCode: String? = null
) {
    fun toUniversityItem() = run {
        UniversityItem(
            country,
            webPages,
            name,
            domains,
            stateProvince,
            alphaTwoCode
        )
    }
}