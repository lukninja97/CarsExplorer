package com.lukninja.carsexplorer.service.repository.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lukninja.carsexplorer.service.model.entity.MakeEntity

@Database(
    entities = [MakeEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun MakeDao(): MakeDao
}
