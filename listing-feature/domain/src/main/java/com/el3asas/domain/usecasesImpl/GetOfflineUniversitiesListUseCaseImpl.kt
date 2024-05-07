package com.el3asas.domain.usecasesImpl

import com.el3asas.domain.di.IoDispatcher
import com.el3asas.domain.di.OfflineRepo
import com.el3asas.domain.models.UniversityItem
import com.el3asas.domain.repos.UniversitiesRepo
import com.el3asas.domain.usecases.GetUniversitiesListUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetOfflineUniversitiesListUseCaseImpl @Inject constructor(
    @OfflineRepo private val repo: UniversitiesRepo,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : GetUniversitiesListUseCase {

    override suspend fun invoke(country: String): List<UniversityItem> = withContext(dispatcher) {
        repo.getUniversities(country)
    }
}