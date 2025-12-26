package com.lukninja.carsexplorer.service.repository.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lukninja.carsexplorer.service.model.entity.ManufacturerEntity

@Dao
interface ManufacturerDao {

    @Query("SELECT * FROM manufacturer ORDER BY manufacturerCommonName ASC")
    suspend fun getAllManufactures(): List<ManufacturerEntity>

    @Query("SELECT * FROM manufacturer WHERE manufacturerId = :id")
    suspend fun getManufacturerById(id: Int): ManufacturerEntity

    @Query("SELECT * FROM manufacturer WHERE make = :make ORDER BY manufacturerCommonName ASC")
    suspend fun getManufacturesByMake(make: String): List<ManufacturerEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(manufactures: List<ManufacturerEntity>)

    @Query("DELETE FROM manufacturer WHERE manufacturerId = :id")
    suspend fun deleteById(id: Int)
}
