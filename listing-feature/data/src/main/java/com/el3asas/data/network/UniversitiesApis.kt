package com.el3asas.data.network

import com.el3asas.domain.models.UniversityItem
import retrofit2.http.GET
import retrofit2.http.Query

interface UniversitiesApis {
    @GET("search")
    suspend fun getUniversities(@Query("country") country: String): List<UniversityItem>
}