package com.lukninja.carsexplorer.service.repository.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lukninja.carsexplorer.service.model.entity.MakeEntity
import com.lukninja.carsexplorer.service.model.entity.ManufacturerEntity
import com.lukninja.carsexplorer.service.model.entity.ModelEntity

@Database(
    entities = [
        MakeEntity::class,
        ManufacturerEntity::class,
        ModelEntity::class,
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun MakeDao(): MakeDao
    abstract fun ManufacturerDao(): ManufacturerDao
    abstract fun ModelDao(): ModelDao
}
