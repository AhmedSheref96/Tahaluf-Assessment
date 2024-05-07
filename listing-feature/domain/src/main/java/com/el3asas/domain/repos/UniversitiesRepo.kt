package com.el3asas.domain.repos

import com.el3asas.domain.models.UniversityItem

interface UniversitiesRepo {
    suspend fun getUniversities(country:String): List<UniversityItem>
}