package com.lukninja.carsexplorer.di

import com.lukninja.carsexplorer.service.repository.IMakeRepository
import com.lukninja.carsexplorer.service.repository.IManufacturerRepository
import com.lukninja.carsexplorer.service.repository.IModelRepository
import com.lukninja.carsexplorer.service.repository.MakeRepository
import com.lukninja.carsexplorer.service.repository.ManufacturerRepository
import com.lukninja.carsexplorer.service.repository.ModelRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindMakeRepository(
        makeRepository: MakeRepository
    ): IMakeRepository

    @Binds
    @Singleton
    abstract fun bindManufacturerRepository(
        manufacturerRepository: ManufacturerRepository
    ): IManufacturerRepository


    @Binds
    @Singleton
    abstract fun bindModelRepository(
        modelRepository: ModelRepository
    ): IModelRepository

}