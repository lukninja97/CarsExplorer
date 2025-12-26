package com.lukninja.carsexplorer.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.lukninja.carsexplorer.service.repository.local.AppDatabase
import com.lukninja.carsexplorer.service.repository.local.MakeDao
import com.lukninja.carsexplorer.service.repository.local.ManufacturerDao
import com.lukninja.carsexplorer.service.repository.local.ModelDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "cars_explorer_db"
        ).build()

    @Provides
    fun provideMakeDao(db: AppDatabase): MakeDao =
        db.makeDao()

    @Provides
    fun provideManufacturerDao(db: AppDatabase): ManufacturerDao =
        db.manufacturerDao()

    @Provides
    fun provideModelDao(db: AppDatabase): ModelDao =
        db.modelDao()
}
