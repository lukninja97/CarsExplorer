package com.lukninja.carsexplorer.service.repository.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lukninja.carsexplorer.service.model.entity.ManufacturerEntity
import com.lukninja.carsexplorer.service.model.entity.ModelEntity

@Dao
interface ModelDao {

    @Query("SELECT * FROM model WHERE makeName = :make ORDER BY name ASC")
    suspend fun getModelsByMake(make: String): List<ModelEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(manufactures: List<ModelEntity>)

    @Query("DELETE FROM manufacturer WHERE manufacturerId = :id")
    suspend fun deleteById(id: Int)
}
