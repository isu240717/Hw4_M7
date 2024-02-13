package com.example.hw4_m7

import android.app.Application
import androidx.room.Room
import com.example.hw4_m7.data.AppDatabase

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "database-name"
        ).allowMainThreadQueries().build()
    }

    companion object{
        lateinit var db: AppDatabase
    }
}