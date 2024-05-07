package com.el3asas.data.repo

import com.el3asas.data.network.UniversitiesApis
import com.el3asas.domain.models.UniversityItem
import com.el3asas.domain.repos.UniversitiesRepo
import javax.inject.Inject

class UniversitiesNetworkRepoImpl @Inject constructor(private val universitiesApis: UniversitiesApis) :
    UniversitiesRepo {
    override suspend fun getUniversities(country: String): List<UniversityItem> =
        universitiesApis.getUniversities(country)
}