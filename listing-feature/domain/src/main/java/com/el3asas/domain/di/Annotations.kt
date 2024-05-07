package com.el3asas.domain.di

import javax.inject.Qualifier

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class OfflineRepo

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class OnlineRepo