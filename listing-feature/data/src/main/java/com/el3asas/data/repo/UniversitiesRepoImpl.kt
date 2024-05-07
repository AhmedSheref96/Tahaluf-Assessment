package com.el3asas.data.repo

import com.el3asas.data.local.daos.UniversitiesDao
import com.el3asas.data.local.enities.toEntity
import com.el3asas.data.network.UniversitiesApis
import com.el3asas.domain.di.IoDispatcher
import com.el3asas.domain.models.UniversityItem
import com.el3asas.domain.repos.UniversitiesRepo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UniversitiesRepoImpl @Inject constructor(
    private val universitiesApis: UniversitiesApis,
    private val dao: UniversitiesDao,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : UniversitiesRepo {
    override suspend fun getUniversities(country: String): List<UniversityItem> =
        withContext(dispatcher) {
            val result = runCatching { universitiesApis.getUniversities(country) }.onSuccess {
                dao.deleteAll()
                dao.insertAll(it.map { it.toEntity() })
            }
            return@withContext result.getOrDefault(
                dao.getAll(country).map { it.toUniversityItem() }.takeIf { it.isNotEmpty() }
                    ?: throw Throwable("Empty Local DB.")
            )
        }
}