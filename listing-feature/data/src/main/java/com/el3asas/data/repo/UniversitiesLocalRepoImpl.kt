package com.el3asas.data.repo

import com.el3asas.data.local.daos.UniversitiesDao
import com.el3asas.data.network.UniversitiesApis
import com.el3asas.domain.models.UniversityItem
import com.el3asas.domain.repos.UniversitiesRepo
import javax.inject.Inject

class UniversitiesLocalRepoImpl @Inject constructor(private val dao: UniversitiesDao) :
    UniversitiesRepo {
    override suspend fun getUniversities(country: String): List<UniversityItem> =
        dao.getAll(country).map { it.toUniversityItem() }
}