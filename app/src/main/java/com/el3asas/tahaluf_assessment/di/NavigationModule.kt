package com.el3asas.tahaluf_assessment.di

import com.el3asas.listing_ui.actions.ListingFeatureActions
import com.el3asas.tahaluf_assessment.actions.ListingScreenActionsImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NavigationModule {

    @Binds
    @Singleton
    abstract fun bindListingScreenActions(listingScreenActionsImpl: ListingScreenActionsImpl): ListingFeatureActions

}