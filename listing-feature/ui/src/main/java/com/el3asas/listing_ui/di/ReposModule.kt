package com.el3asas.listing_ui.di

import com.el3asas.data.repo.UniversitiesLocalRepoImpl
import com.el3asas.data.repo.UniversitiesNetworkRepoImpl
import com.el3asas.domain.di.OfflineRepo
import com.el3asas.domain.di.OnlineRepo
import com.el3asas.domain.repos.UniversitiesRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ReposModule {

    @OnlineRepo
    @Binds
    @Singleton
    abstract fun bindsOnlineRepo(universitiesNetworkRepoImpl: UniversitiesNetworkRepoImpl): UniversitiesRepo

    @OfflineRepo
    @Binds
    @Singleton
    abstract fun bindsOfflineRepo(universitiesLocalRepoImpl: UniversitiesLocalRepoImpl): UniversitiesRepo

}