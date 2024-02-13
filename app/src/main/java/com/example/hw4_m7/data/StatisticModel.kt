package com.example.hw4_m7.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "statisticModel")
data class StatisticModel(
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null,
    val status:String?=null,
    val difficulty:String?=null,
    val mistakes:String?=null,
    val result:String?=null,
): Serializable