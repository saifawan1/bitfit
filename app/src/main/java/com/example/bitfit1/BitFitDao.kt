package com.example.bitfit1

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BitFitDao {
    @Query("SELECT * FROM bitFit_table")
    fun getAll(): Flow<List<BitFitEntity>>

    @Insert
    fun insertAll(items: List<BitFitEntity>)

    @Insert
    fun insert(item: BitFitEntity)

    @Query("DELETE FROM bitFit_table")
    fun deleteAll()
}