package com.example.hw4_m7.statistic

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.hw4_m7.data.Repository
import com.example.hw4_m7.data.StatisticModel

class StaticViewModel: ViewModel() {
    private val repository = Repository()
    fun getStatistic(): LiveData<List<StatisticModel>> = repository.getStatistic()
}