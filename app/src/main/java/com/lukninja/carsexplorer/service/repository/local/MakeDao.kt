package com.lukninja.carsexplorer.service.repository.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lukninja.carsexplorer.service.model.entity.MakeEntity

@Dao
interface MakeDao {

    @Query("SELECT * FROM make")
    suspend fun getAllMakes(): List<MakeEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(makes: List<MakeEntity>)

    @Query("DELETE FROM make WHERE id = :id")
    suspend fun deleteByMake(id: Int)
}
