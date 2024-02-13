package com.example.hw4_m7.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [StatisticModel::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun staticDao(): StatisticDao
}