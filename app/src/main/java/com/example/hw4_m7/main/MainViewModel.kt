package com.example.hw4_m7.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.hw4_m7.data.Repository
import com.example.hw4_m7.data.StatisticModel

class MainViewModel: ViewModel() {
    private val repository = Repository()
    fun addStatistic(model: StatisticModel): LiveData<Long> = repository.addStatistic(model)
}