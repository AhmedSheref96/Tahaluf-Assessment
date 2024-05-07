package com.el3asas.domain.di

import com.el3asas.domain.usecases.GetUniversitiesListUseCase
import com.el3asas.domain.usecasesImpl.GetOfflineUniversitiesListUseCaseImpl
import com.el3asas.domain.usecasesImpl.GetOnlineUniversitiesListUseCaseImpl
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
    @OnlineRepo
    abstract fun bindsGetOnlineUniversitiesUseCase(getOnlineUniversitiesListUseCaseImpl: GetOnlineUniversitiesListUseCaseImpl): GetUniversitiesListUseCase

    @Binds
    @Singleton
    @OfflineRepo
    abstract fun bindsGetOfflineUniversitiesUseCase(getOfflineUniversitiesListUseCaseImpl: GetOfflineUniversitiesListUseCaseImpl): GetUniversitiesListUseCase

}

