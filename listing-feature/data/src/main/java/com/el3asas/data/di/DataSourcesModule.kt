package com.el3asas.data.di

import android.content.Context
import androidx.room.Room
import com.el3asas.data.local.RoomDB
import com.el3asas.data.network.UniversitiesApis
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataSourcesModule {

    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://universities.hipolabs.com/")
            .build()

    @Provides
    @Singleton
    fun provideUniversitiesApis(retrofit: Retrofit): UniversitiesApis = retrofit.create(UniversitiesApis::class.java)

    @Provides
    @Singleton
    fun provideRoomDB(@ApplicationContext context: Context): RoomDB =
        Room.databaseBuilder(context, RoomDB::class.java, "Tahaluf-DB")
            .build()


    @Provides
    @Singleton
    fun provideUniversitiesDao(roomDB: RoomDB) = roomDB.universitiesDao()


}