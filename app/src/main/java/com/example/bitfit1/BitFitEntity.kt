package com.example.bitfit1

import androidx.room.*

@Entity(tableName = "bitFit_table")
data class BitFitEntity (
    @PrimaryKey(autoGenerate = true) val id: Long = 0 ,
    @ColumnInfo(name = "foodName") val foodName: String?,
    @ColumnInfo(name = "calories") val calories: String?
)