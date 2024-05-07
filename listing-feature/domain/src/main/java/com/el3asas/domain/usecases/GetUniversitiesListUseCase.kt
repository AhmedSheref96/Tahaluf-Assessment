package com.el3asas.domain.usecases

import com.el3asas.domain.models.UniversityItem

interface GetUniversitiesListUseCase {
    suspend operator fun invoke(country:String): List<UniversityItem>
}