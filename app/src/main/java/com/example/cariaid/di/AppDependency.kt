package com.example.cariaid.di

import android.content.Context
import com.example.cariaid.data.dataStore.DataStoreImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppDependency {

    @Provides
    @Singleton
    fun provideDataStore(@ApplicationContext context:Context) = DataStoreImpl(context)

}