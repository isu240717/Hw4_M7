package com.example.hw4_m7.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.Deferred

@Dao
interface StatisticDao {

    @Query("SELECT * FROM statisticModel")
    fun getAll(): List<StatisticModel>

    @Insert
    fun insert(model: StatisticModel): Long

    @Delete
    fun delete(model: StatisticModel)

}