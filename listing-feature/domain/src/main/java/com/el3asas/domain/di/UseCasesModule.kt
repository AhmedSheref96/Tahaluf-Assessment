package com.el3asas.domain.di

import com.el3asas.domain.usecases.GetUniversitiesListUseCase
import com.el3asas.domain.usecasesImpl.GetUniversitiesListUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCasesModule {

    @Binds
    @Singleton
    abstract fun bindsGetOnlineUniversitiesUseCase(getUniversitiesListUseCaseImpl: GetUniversitiesListUseCaseImpl): GetUniversitiesListUseCase

}

