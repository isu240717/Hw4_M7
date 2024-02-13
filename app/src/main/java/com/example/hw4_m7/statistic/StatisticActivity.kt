package com.example.hw4_m7.statistic

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.hw4_m7.App
import com.example.hw4_m7.data.StatisticModel
import com.example.hw4_m7.databinding.ActivityStatisticBinding

class StatisticActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStatisticBinding
    private val viewModel: StaticViewModel by viewModels()
    private val adapter = StatisticAdapter(this::onLongClick)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityStatisticBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rv.adapter = adapter

        viewModel.getStatistic().observe(this) { statistic ->
            adapter.addStatistics(statistic)
        }
    }


    private fun onLongClick(statisticModel: StatisticModel): Boolean {
        val alertDialBuilder = AlertDialog.Builder(this)
            .setMessage("Вы хотите удалить статистику?")

            .setPositiveButton("Да") { _, _ ->
                App.db.staticDao().delete(statisticModel)
                adapter.notifyDataSetChanged()
            }

            .setNegativeButton("Нет") { dialog, _ ->
                dialog.dismiss()
            }

        val alertDialog = alertDialBuilder.create()
        alertDialog.show()
        return true
    }
}
