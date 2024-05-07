package com.el3asas.listing_ui.di

import com.el3asas.data.repo.UniversitiesRepoImpl
import com.el3asas.domain.repos.UniversitiesRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ReposModule {

    @Binds
    @Singleton
    abstract fun bindsRepo(universitiesRepoImpl: UniversitiesRepoImpl): UniversitiesRepo

}